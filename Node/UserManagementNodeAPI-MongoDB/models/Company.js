class Company {
    constructor(data) {
        this.id = data.id || null;
        this.name = data.name || null;
        this.catchPhrase = data.catchPhrase ?? data.catch_phrase ?? null;
        this.bs = data.bs || null;
    }

    static fromDoc(doc) {
        if (!doc) return null;
        return new Company({
            id: doc._id ? doc._id.toString() : null,
            name: doc.name,
            catchPhrase: doc.catchPhrase,
            bs: doc.bs
        });
    }

    static fromEmbedded(doc) {
        if (!doc) return null;
        return new Company({
            name: doc.name,
            catchPhrase: doc.catchPhrase,
            bs: doc.bs
        });
    }

    toDoc() {
        return {
            name: this.name,
            catchPhrase: this.catchPhrase,
            bs: this.bs
        };
    }
}

module.exports = Company;
