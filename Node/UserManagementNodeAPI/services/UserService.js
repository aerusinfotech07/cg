const pool = require('../config/database');
const User = require('../models/User');
const Address = require('../models/Address');
const Geo = require('../models/Geo');
const Company = require('../models/Company');

class UserService {
    async getAllUsers() {
        const query = `
            SELECT 
                u.id as user_id, u.name as user_name, u.username as user_username, 
                u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite,
                a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, 
                c.catch_phrase as company_catch_phrase, c.bs as company_bs
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
            SELECT 
                u.id as user_id, u.name as user_name, u.username as user_username, 
                u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite,
                a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, 
                c.catch_phrase as company_catch_phrase, c.bs as company_bs
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
            SELECT 
                u.id as user_id, u.name as user_name, u.username as user_username, 
                u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite,
                a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, 
                c.catch_phrase as company_catch_phrase, c.bs as company_bs
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
            SELECT 
                u.id as user_id, u.name as user_name, u.username as user_username, 
                u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite,
                a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, 
                c.catch_phrase as company_catch_phrase, c.bs as company_bs
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
        const query = 'SELECT COUNT(*) as count FROM users WHERE username = ?';
        const [rows] = await pool.execute(query, [username]);
        return rows[0].count > 0;
    }

    async existsByEmail(email) {
        const query = 'SELECT COUNT(*) as count FROM users WHERE email = ?';
        const [rows] = await pool.execute(query, [email]);
        return rows[0].count > 0;
    }

    async createUser(userData) {
        const connection = await pool.getConnection();
        try {
            await connection.beginTransaction();

            // Check if username already exists
            if (await this.existsByUsername(userData.username)) {
                throw new Error('Username already exists: ' + userData.username);
            }

            // Check if email already exists
            if (await this.existsByEmail(userData.email)) {
                throw new Error('Email already exists: ' + userData.email);
            }

            let geoId = null;
            let addressId = null;
            let companyId = null;

            // Create Geo if provided
            if (userData.address && userData.address.geo) {
                const geo = new Geo(userData.address.geo);
                const geoValues = geo.toDbValues();
                const [geoResult] = await connection.execute(
                    'INSERT INTO geo (lat, lng) VALUES (?, ?)',
                    [geoValues.lat, geoValues.lng]
                );
                geoId = geoResult.insertId;
            }

            // Create Address if provided
            if (userData.address) {
                const address = new Address(userData.address);
                const addressValues = address.toDbValues();
                const [addressResult] = await connection.execute(
                    'INSERT INTO address (street, suite, city, zipcode, geo_id) VALUES (?, ?, ?, ?, ?)',
                    [addressValues.street, addressValues.suite, addressValues.city, addressValues.zipcode, geoId]
                );
                addressId = addressResult.insertId;
            }

            // Create Company if provided
            if (userData.company) {
                const company = new Company(userData.company);
                const companyValues = company.toDbValues();
                const [companyResult] = await connection.execute(
                    'INSERT INTO company (name, catch_phrase, bs) VALUES (?, ?, ?)',
                    [companyValues.name, companyValues.catch_phrase, companyValues.bs]
                );
                companyId = companyResult.insertId;
            }

            // Create User
            const user = new User(userData);
            const userValues = user.toDbValues();
            const [userResult] = await connection.execute(
                'INSERT INTO users (name, username, email, phone, website, address_id, company_id) VALUES (?, ?, ?, ?, ?, ?, ?)',
                [userValues.name, userValues.username, userValues.email, userValues.phone, userValues.website, addressId, companyId]
            );

            await connection.commit();
            return await this.getUserById(userResult.insertId);
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
            if (!existingUser) {
                throw new Error('User not found with id: ' + id);
            }

            // Check if username is being changed and if it already exists
            if (userData.username && userData.username !== existingUser.username) {
                if (await this.existsByUsername(userData.username)) {
                    throw new Error('Username already exists: ' + userData.username);
                }
            }

            // Check if email is being changed and if it already exists
            if (userData.email && userData.email !== existingUser.email) {
                if (await this.existsByEmail(userData.email)) {
                    throw new Error('Email already exists: ' + userData.email);
                }
            }

            // Update Geo if provided
            if (userData.address && userData.address.geo) {
                if (existingUser.address && existingUser.address.geo) {
                    const geo = new Geo(userData.address.geo);
                    const geoValues = geo.toDbValues();
                    await connection.execute(
                        'UPDATE geo SET lat = ?, lng = ? WHERE id = ?',
                        [geoValues.lat, geoValues.lng, existingUser.address.geo.id]
                    );
                } else if (existingUser.address) {
                    const geo = new Geo(userData.address.geo);
                    const geoValues = geo.toDbValues();
                    const [geoResult] = await connection.execute(
                        'INSERT INTO geo (lat, lng) VALUES (?, ?)',
                        [geoValues.lat, geoValues.lng]
                    );
                    await connection.execute(
                        'UPDATE address SET geo_id = ? WHERE id = ?',
                        [geoResult.insertId, existingUser.address.id]
                    );
                }
            }

            // Update Address if provided
            if (userData.address) {
                if (existingUser.address) {
                    const address = new Address(userData.address);
                    const addressValues = address.toDbValues();
                    await connection.execute(
                        'UPDATE address SET street = ?, suite = ?, city = ?, zipcode = ? WHERE id = ?',
                        [addressValues.street, addressValues.suite, addressValues.city, addressValues.zipcode, existingUser.address.id]
                    );
                } else {
                    let geoId = null;
                    if (userData.address.geo) {
                        const geo = new Geo(userData.address.geo);
                        const geoValues = geo.toDbValues();
                        const [geoResult] = await connection.execute(
                            'INSERT INTO geo (lat, lng) VALUES (?, ?)',
                            [geoValues.lat, geoValues.lng]
                        );
                        geoId = geoResult.insertId;
                    }
                    const address = new Address(userData.address);
                    const addressValues = address.toDbValues();
                    const [addressResult] = await connection.execute(
                        'INSERT INTO address (street, suite, city, zipcode, geo_id) VALUES (?, ?, ?, ?, ?)',
                        [addressValues.street, addressValues.suite, addressValues.city, addressValues.zipcode, geoId]
                    );
                    await connection.execute(
                        'UPDATE users SET address_id = ? WHERE id = ?',
                        [addressResult.insertId, id]
                    );
                }
            }

            // Update Company if provided
            if (userData.company) {
                if (existingUser.company) {
                    const company = new Company(userData.company);
                    const companyValues = company.toDbValues();
                    await connection.execute(
                        'UPDATE company SET name = ?, catch_phrase = ?, bs = ? WHERE id = ?',
                        [companyValues.name, companyValues.catch_phrase, companyValues.bs, existingUser.company.id]
                    );
                } else {
                    const company = new Company(userData.company);
                    const companyValues = company.toDbValues();
                    const [companyResult] = await connection.execute(
                        'INSERT INTO company (name, catch_phrase, bs) VALUES (?, ?, ?)',
                        [companyValues.name, companyValues.catch_phrase, companyValues.bs]
                    );
                    await connection.execute(
                        'UPDATE users SET company_id = ? WHERE id = ?',
                        [companyResult.insertId, id]
                    );
                }
            }

            // Update User
            const user = new User(userData);
            const userValues = user.toDbValues();
            await connection.execute(
                'UPDATE users SET name = ?, username = ?, email = ?, phone = ?, website = ? WHERE id = ?',
                [userValues.name || existingUser.name, 
                 userValues.username || existingUser.username, 
                 userValues.email || existingUser.email,
                 userValues.phone !== undefined ? userValues.phone : existingUser.phone,
                 userValues.website !== undefined ? userValues.website : existingUser.website,
                 id]
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
            if (!user) {
                throw new Error('User not found with id: ' + id);
            }

            // Delete user (cascade will handle related records if foreign keys are set up)
            await connection.execute('DELETE FROM users WHERE id = ?', [id]);

            // Clean up orphaned records
            if (user.address) {
                if (user.address.geo) {
                    await connection.execute('DELETE FROM geo WHERE id = ?', [user.address.geo.id]);
                }
                await connection.execute('DELETE FROM address WHERE id = ?', [user.address.id]);
            }
            if (user.company) {
                await connection.execute('DELETE FROM company WHERE id = ?', [user.company.id]);
            }

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
