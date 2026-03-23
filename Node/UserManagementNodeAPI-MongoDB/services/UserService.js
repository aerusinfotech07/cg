const { ObjectId } = require('mongodb');
const { getDb } = require('../config/database');
const User = require('../models/User');

const COLLECTION = 'users';

async function getCollection() {
    const db = await getDb();
    return db.collection(COLLECTION);
}

class UserService {
    async getAllUsers() {
        const col = await getCollection();
        const cursor = col.find({}).sort({ _id: 1 });
        const docs = await cursor.toArray();
        return docs.map(doc => User.fromDoc(doc));
    }

    async getUserById(id) {
        if (!ObjectId.isValid(id)) return null;
        const col = await getCollection();
        const doc = await col.findOne({ _id: new ObjectId(id) });
        return doc ? User.fromDoc(doc) : null;
    }

    async getUserByUsername(username) {
        const col = await getCollection();
        const doc = await col.findOne({ username });
        return doc ? User.fromDoc(doc) : null;
    }

    async getUserByEmail(email) {
        const col = await getCollection();
        const doc = await col.findOne({ email });
        return doc ? User.fromDoc(doc) : null;
    }

    async existsByUsername(username) {
        const col = await getCollection();
        const doc = await col.findOne({ username });
        return !!doc;
    }

    async existsByEmail(email) {
        const col = await getCollection();
        const doc = await col.findOne({ email });
        return !!doc;
    }

    async createUser(userData) {
        if (await this.existsByUsername(userData.username)) {
            throw new Error('Username already exists: ' + userData.username);
        }
        if (await this.existsByEmail(userData.email)) {
            throw new Error('Email already exists: ' + userData.email);
        }

        const user = new User(userData);
        const doc = user.toDoc();
        const col = await getCollection();
        const result = await col.insertOne(doc);
        return await this.getUserById(result.insertedId.toString());
    }

    async updateUser(id, userData) {
        if (!ObjectId.isValid(id)) {
            throw new Error('User not found with id: ' + id);
        }
        const existingUser = await this.getUserById(id);
        if (!existingUser) {
            throw new Error('User not found with id: ' + id);
        }

        if (userData.username && userData.username !== existingUser.username) {
            if (await this.existsByUsername(userData.username)) {
                throw new Error('Username already exists: ' + userData.username);
            }
        }
        if (userData.email && userData.email !== existingUser.email) {
            if (await this.existsByEmail(userData.email)) {
                throw new Error('Email already exists: ' + userData.email);
            }
        }

        const user = new User({ ...existingUser, ...userData });
        const doc = user.toDoc();
        const col = await getCollection();
        await col.updateOne(
            { _id: new ObjectId(id) },
            { $set: doc }
        );
        return await this.getUserById(id);
    }

    async deleteUser(id) {
        if (!ObjectId.isValid(id)) {
            throw new Error('User not found with id: ' + id);
        }
        const user = await this.getUserById(id);
        if (!user) {
            throw new Error('User not found with id: ' + id);
        }
        const col = await getCollection();
        await col.deleteOne({ _id: new ObjectId(id) });
    }
}

module.exports = new UserService();
