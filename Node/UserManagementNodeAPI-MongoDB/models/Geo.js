class Geo {
    constructor(data) {
        this.id = data.id || null;
        this.lat = data.lat || null;
        this.lng = data.lng || null;
    }

    static fromDoc(doc) {
        if (!doc) return null;
        return new Geo({
            id: doc._id ? doc._id.toString() : null,
            lat: doc.lat,
            lng: doc.lng
        });
    }

    static fromEmbedded(doc) {
        if (!doc) return null;
        return new Geo({ lat: doc.lat, lng: doc.lng });
    }

    toDoc() {
        return {
            lat: this.lat,
            lng: this.lng
        };
    }
}

module.exports = Geo;
