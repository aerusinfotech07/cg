class Company {
    constructor(data) {
        this.id = data.id || null;
        this.name = data.name || null;
        this.catchPhrase = data.catchPhrase || null;
        this.bs = data.bs || null;
    }

    static fromDbRow(row) {
        if (!row) return null;
        return new Company({
            id: row.company_id,
            name: row.company_name,
            catchPhrase: row.company_catch_phrase,
            bs: row.company_bs
        });
    }

    toDbValues() {
        return {
            name: this.name,
            catch_phrase: this.catchPhrase,
            bs: this.bs
        };
    }
}

module.exports = Company;
