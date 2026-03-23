const pool = require('../config/database');
const bcrypt = require('bcryptjs');

class AuthService {
    async validateUser(username, password) {
        if (!username || !password) return null;
        const [rows] = await pool.execute(
            'SELECT id, username, password_hash FROM auth_users WHERE username = ?',
            [username]
        );
        if (rows.length === 0) return null;
        const user = rows[0];
        const valid = await bcrypt.compare(password, user.password_hash);
        return valid ? { id: user.id, username: user.username } : null;
    }
}

module.exports = new AuthService();
