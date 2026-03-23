const pool = require('../config/database');
const User = require('../models/User');
const Address = require('../models/Address');
const Geo = require('../models/Geo');
const Company = require('../models/Company');

class UserService {
    async getAllUsers() {
        const query = `
            SELECT u.id as user_id, u.name as user_name, u.username as user_username, u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite, a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, c.catch_phrase as company_catch_phrase, c.bs as company_bs
            FROM users u
            LEFT JOIN address a ON u.address_id = a.id
            LEFT JOIN geo g ON a.geo_id = g.id
            LEFT JOIN company c ON u.company_id = c.id
            ORDER BY u.id
        `;
        const [rows] = await pool.execute(query);
        return rows.map(row => User.fromDbRow(row));
    }

    async getUserById(id) {
        const query = `
            SELECT u.id as user_id, u.name as user_name, u.username as user_username, u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite, a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, c.catch_phrase as company_catch_phrase, c.bs as company_bs
            FROM users u
            LEFT JOIN address a ON u.address_id = a.id
            LEFT JOIN geo g ON a.geo_id = g.id
            LEFT JOIN company c ON u.company_id = c.id
            WHERE u.id = ?
        `;
        const [rows] = await pool.execute(query, [id]);
        return rows.length > 0 ? User.fromDbRow(rows[0]) : null;
    }

    async getUserByUsername(username) {
        const query = `
            SELECT u.id as user_id, u.name as user_name, u.username as user_username, u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite, a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, c.catch_phrase as company_catch_phrase, c.bs as company_bs
            FROM users u
            LEFT JOIN address a ON u.address_id = a.id
            LEFT JOIN geo g ON a.geo_id = g.id
            LEFT JOIN company c ON u.company_id = c.id
            WHERE u.username = ?
        `;
        const [rows] = await pool.execute(query, [username]);
        return rows.length > 0 ? User.fromDbRow(rows[0]) : null;
    }

    async getUserByEmail(email) {
        const query = `
            SELECT u.id as user_id, u.name as user_name, u.username as user_username, u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite, a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, c.catch_phrase as company_catch_phrase, c.bs as company_bs
            FROM users u
            LEFT JOIN address a ON u.address_id = a.id
            LEFT JOIN geo g ON a.geo_id = g.id
            LEFT JOIN company c ON u.company_id = c.id
            WHERE u.email = ?
        `;
        const [rows] = await pool.execute(query, [email]);
        return rows.length > 0 ? User.fromDbRow(rows[0]) : null;
    }

    async existsByUsername(username) {
        const [rows] = await pool.execute('SELECT COUNT(*) as count FROM users WHERE username = ?', [username]);
        return rows[0].count > 0;
    }

    async existsByEmail(email) {
        const [rows] = await pool.execute('SELECT COUNT(*) as count FROM users WHERE email = ?', [email]);
        return rows[0].count > 0;
    }

    async createUser(userData) {
        const connection = await pool.getConnection();
        try {
            await connection.beginTransaction();
            if (await this.existsByUsername(userData.username)) throw new Error('Username already exists: ' + userData.username);
            if (await this.existsByEmail(userData.email)) throw new Error('Email already exists: ' + userData.email);
            let geoId = null, addressId = null, companyId = null;
            if (userData.address && userData.address.geo) {
                const geo = new Geo(userData.address.geo);
                const gv = geo.toDbValues();
                const [gr] = await connection.execute('INSERT INTO geo (lat, lng) VALUES (?, ?)', [gv.lat, gv.lng]);
                geoId = gr.insertId;
            }
            if (userData.address) {
                const address = new Address(userData.address);
                const av = address.toDbValues();
                const [ar] = await connection.execute(
                    'INSERT INTO address (street, suite, city, zipcode, geo_id) VALUES (?, ?, ?, ?, ?)',
                    [av.street, av.suite, av.city, av.zipcode, geoId]
                );
                addressId = ar.insertId;
            }
            if (userData.company) {
                const company = new Company(userData.company);
                const cv = company.toDbValues();
                const [cr] = await connection.execute('INSERT INTO company (name, catch_phrase, bs) VALUES (?, ?, ?)', [cv.name, cv.catch_phrase, cv.bs]);
                companyId = cr.insertId;
            }
            const user = new User(userData);
            const uv = user.toDbValues();
            const [ur] = await connection.execute(
                'INSERT INTO users (name, username, email, phone, website, address_id, company_id) VALUES (?, ?, ?, ?, ?, ?, ?)',
                [uv.name, uv.username, uv.email, uv.phone, uv.website, addressId, companyId]
            );
            await connection.commit();
            return await this.getUserById(ur.insertId);
        } catch (error) {
            await connection.rollback();
            throw error;
        } finally {
            connection.release();
        }
    }

    async updateUser(id, userData) {
        const connection = await pool.getConnection();
        try {
            await connection.beginTransaction();
            const existingUser = await this.getUserById(id);
            if (!existingUser) throw new Error('User not found with id: ' + id);
            if (userData.username && userData.username !== existingUser.username && (await this.existsByUsername(userData.username))) throw new Error('Username already exists: ' + userData.username);
            if (userData.email && userData.email !== existingUser.email && (await this.existsByEmail(userData.email))) throw new Error('Email already exists: ' + userData.email);
            if (userData.address && userData.address.geo && existingUser.address && existingUser.address.geo) {
                const geo = new Geo(userData.address.geo);
                const gv = geo.toDbValues();
                await connection.execute('UPDATE geo SET lat = ?, lng = ? WHERE id = ?', [gv.lat, gv.lng, existingUser.address.geo.id]);
            } else if (userData.address && userData.address.geo && existingUser.address) {
                const geo = new Geo(userData.address.geo);
                const gv = geo.toDbValues();
                const [gr] = await connection.execute('INSERT INTO geo (lat, lng) VALUES (?, ?)', [gv.lat, gv.lng]);
                await connection.execute('UPDATE address SET geo_id = ? WHERE id = ?', [gr.insertId, existingUser.address.id]);
            }
            if (userData.address) {
                if (existingUser.address) {
                    const address = new Address(userData.address);
                    const av = address.toDbValues();
                    await connection.execute('UPDATE address SET street = ?, suite = ?, city = ?, zipcode = ? WHERE id = ?', [av.street, av.suite, av.city, av.zipcode, existingUser.address.id]);
                } else {
                    let geoId = null;
                    if (userData.address.geo) {
                        const geo = new Geo(userData.address.geo);
                        const gv = geo.toDbValues();
                        const [gr] = await connection.execute('INSERT INTO geo (lat, lng) VALUES (?, ?)', [gv.lat, gv.lng]);
                        geoId = gr.insertId;
                    }
                    const address = new Address(userData.address);
                    const av = address.toDbValues();
                    const [ar] = await connection.execute('INSERT INTO address (street, suite, city, zipcode, geo_id) VALUES (?, ?, ?, ?, ?)', [av.street, av.suite, av.city, av.zipcode, geoId]);
                    await connection.execute('UPDATE users SET address_id = ? WHERE id = ?', [ar.insertId, id]);
                }
            }
            if (userData.company) {
                if (existingUser.company) {
                    const company = new Company(userData.company);
                    const cv = company.toDbValues();
                    await connection.execute('UPDATE company SET name = ?, catch_phrase = ?, bs = ? WHERE id = ?', [cv.name, cv.catch_phrase, cv.bs, existingUser.company.id]);
                } else {
                    const company = new Company(userData.company);
                    const cv = company.toDbValues();
                    const [cr] = await connection.execute('INSERT INTO company (name, catch_phrase, bs) VALUES (?, ?, ?)', [cv.name, cv.catch_phrase, cv.bs]);
                    await connection.execute('UPDATE users SET company_id = ? WHERE id = ?', [cr.insertId, id]);
                }
            }
            const user = new User(userData);
            const uv = user.toDbValues();
            await connection.execute(
                'UPDATE users SET name = ?, username = ?, email = ?, phone = ?, website = ? WHERE id = ?',
                [uv.name || existingUser.name, uv.username || existingUser.username, uv.email || existingUser.email, uv.phone !== undefined ? uv.phone : existingUser.phone, uv.website !== undefined ? uv.website : existingUser.website, id]
            );
            await connection.commit();
            return await this.getUserById(id);
        } catch (error) {
            await connection.rollback();
            throw error;
        } finally {
            connection.release();
        }
    }

    async deleteUser(id) {
        const connection = await pool.getConnection();
        try {
            await connection.beginTransaction();
            const user = await this.getUserById(id);
            if (!user) throw new Error('User not found with id: ' + id);
            await connection.execute('DELETE FROM users WHERE id = ?', [id]);
            if (user.address) {
                if (user.address.geo) await connection.execute('DELETE FROM geo WHERE id = ?', [user.address.geo.id]);
                await connection.execute('DELETE FROM address WHERE id = ?', [user.address.id]);
            }
            if (user.company) await connection.execute('DELETE FROM company WHERE id = ?', [user.company.id]);
            await connection.commit();
        } catch (error) {
            await connection.rollback();
            throw error;
        } finally {
            connection.release();
        }
    }
}

module.exports = new UserService();
