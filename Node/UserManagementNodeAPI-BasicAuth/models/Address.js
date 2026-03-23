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

    static fromDbRow(row) {
        if (!row) return null;
        const address = new Address({
            id: row.address_id,
            street: row.address_street,
            suite: row.address_suite,
            city: row.address_city,
            zipcode: row.address_zipcode
        });
        if (row.geo_id) {
            address.geo = Geo.fromDbRow(row);
        }
        return address;
    }

    toDbValues() {
        return {
            street: this.street,
            suite: this.suite,
            city: this.city,
            zipcode: this.zipcode
        };
    }
}

module.exports = Address;
