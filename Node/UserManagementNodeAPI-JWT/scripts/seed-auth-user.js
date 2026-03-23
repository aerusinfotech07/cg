/**
 * Seed an auth user for JWT login.
 * Default: username=admin, password=admin123
 * Run: node scripts/seed-auth-user.js
 */
require('dotenv').config({ path: require('path').join(__dirname, '..', '.env') });
const bcrypt = require('bcryptjs');
const mysql = require('mysql2/promise');

const username = process.env.AUTH_USERNAME || 'admin';
const password = process.env.AUTH_PASSWORD || 'admin123';

async function seed() {
    const pool = mysql.createPool({
        host: process.env.DB_HOST || 'localhost',
        port: process.env.DB_PORT || 3306,
        user: process.env.DB_USER || 'root',
        password: process.env.DB_PASSWORD || '',
        database: process.env.DB_NAME || 'usermanagement'
    });
    const hash = bcrypt.hashSync(password, 10);
    await pool.execute(
        'INSERT INTO auth_users (username, password_hash) VALUES (?, ?) ON DUPLICATE KEY UPDATE password_hash = ?',
        [username, hash, hash]
    );
    console.log(`Auth user "${username}" created/updated. Password: ${password}`);
    await pool.end();
}

seed().catch(err => {
    console.error(err.message);
    process.exit(1);
});
