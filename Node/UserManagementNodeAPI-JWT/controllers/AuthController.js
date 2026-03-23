const authService = require('../services/AuthService');
const jwt = require('jsonwebtoken');
const { JWT_SECRET, JWT_EXPIRES_IN } = require('../config/jwt');

class AuthController {
    async login(req, res) {
        try {
            const { username, password } = req.body || {};
            if (!username || !password) {
                return res.status(400).json({ message: 'Username and password are required' });
            }
            const user = await authService.validateUser(username, password);
            if (!user) {
                return res.status(401).json({ message: 'Invalid username or password' });
            }
            const token = jwt.sign(
                { id: user.id, username: user.username },
                JWT_SECRET,
                { expiresIn: JWT_EXPIRES_IN }
            );
            res.status(200).json({
                token,
                type: 'Bearer',
                expiresIn: JWT_EXPIRES_IN,
                user: { id: user.id, username: user.username }
            });
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    }
}

module.exports = new AuthController();
