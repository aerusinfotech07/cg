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

    static fromDoc(doc) {
        if (!doc) return null;
        const user = new User({
            id: doc._id ? doc._id.toString() : null,
            name: doc.name,
            username: doc.username,
            email: doc.email,
            phone: doc.phone,
            website: doc.website
        });
        if (doc.address) user.address = Address.fromEmbedded(doc.address);
        if (doc.company) user.company = Company.fromEmbedded(doc.company);
        return user;
    }

    toDoc() {
        const doc = {
            name: this.name,
            username: this.username,
            email: this.email,
            phone: this.phone,
            website: this.website
        };
        if (this.address) doc.address = this.address.toDoc();
        if (this.company) doc.company = this.company.toDoc();
        return doc;
    }
}

module.exports = User;
