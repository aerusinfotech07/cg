const Geo = require('./Geo');

class Address {
    constructor(data) {
        this.id = data.id || null;
        this.street = data.street || null;
        this.suite = data.suite || null;
        this.city = data.city || null;
        this.zipcode = data.zipcode || null;
        this.geo = data.geo ? new Geo(data.geo) : null;
    }

    static fromDoc(doc) {
        if (!doc) return null;
        const address = new Address({
            id: doc._id ? doc._id.toString() : null,
            street: doc.street,
            suite: doc.suite,
            city: doc.city,
            zipcode: doc.zipcode
        });
        if (doc.geo) address.geo = Geo.fromEmbedded(doc.geo);
        return address;
    }

    static fromEmbedded(doc) {
        if (!doc) return null;
        const address = new Address({
            street: doc.street,
            suite: doc.suite,
            city: doc.city,
            zipcode: doc.zipcode
        });
        if (doc.geo) address.geo = Geo.fromEmbedded(doc.geo);
        return address;
    }

    toDoc() {
        const doc = {
            street: this.street,
            suite: this.suite,
            city: this.city,
            zipcode: this.zipcode
        };
        if (this.geo) doc.geo = this.geo.toDoc();
        return doc;
    }
}

module.exports = Address;
