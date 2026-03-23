const { MongoClient } = require('mongodb');
require('dotenv').config();

const uri = process.env.MONGODB_URI || 'mongodb://localhost:27017';
const dbName = process.env.DB_NAME || 'usermanagement';

let client = null;
let db = null;

async function connect() {
    if (db) return db;
    client = new MongoClient(uri);
    await client.connect();
    db = client.db(dbName);
    await ensureIndexes(db);
    console.log('Connected to MongoDB');
    return db;
}

async function ensureIndexes(database) {
    const users = database.collection('users');
    await users.createIndex({ username: 1 }, { unique: true });
    await users.createIndex({ email: 1 }, { unique: true });
}

async function getDb() {
    if (!db) await connect();
    return db;
}

async function close() {
    if (client) {
        await client.close();
        client = null;
        db = null;
        console.log('MongoDB connection closed');
    }
}

module.exports = { connect, getDb, close };
