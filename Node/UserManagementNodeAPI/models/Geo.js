class Geo {
    constructor(data) {
        this.id = data.id || null;
        this.lat = data.lat || null;
        this.lng = data.lng || null;
    }

    static fromDbRow(row) {
        if (!row) return null;
        return new Geo({
            id: row.geo_id,
            lat: row.geo_lat,
            lng: row.geo_lng
        });
    }

    toDbValues() {
        return {
            lat: this.lat,
            lng: this.lng
        };
    }
}

module.exports = Geo;
