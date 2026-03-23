const Address = require('./Address');
const Company = require('./Company');

class User {
    constructor(data) {
        this.id = data.id || null;
        this.name = data.name || null;
        this.username = data.username || null;
        this.email = data.email || null;
        this.phone = data.phone || null;
        this.website = data.website || null;
        this.address = data.address ? new Address(data.address) : null;
        this.company = data.company ? new Company(data.company) : null;
    }

    static fromDbRow(row) {
        if (!row) return null;
        const user = new User({
            id: row.user_id,
            name: row.user_name,
            username: row.user_username,
            email: row.user_email,
            phone: row.user_phone,
            website: row.user_website
        });
        if (row.address_id) {
            user.address = Address.fromDbRow(row);
        }
        if (row.company_id) {
            user.company = Company.fromDbRow(row);
        }
        return user;
    }

    toDbValues() {
        return {
            name: this.name,
            username: this.username,
            email: this.email,
            phone: this.phone,
            website: this.website
        };
    }
}

module.exports = User;
