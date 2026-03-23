const jwt = require('jsonwebtoken');
const { JWT_SECRET } = require('../config/jwt');

/**
 * JWT Authentication middleware.
 * Expects header: Authorization: Bearer <token>
 */
function jwtAuth(req, res, next) {
    const authHeader = req.headers.authorization;
    if (!authHeader || !authHeader.startsWith('Bearer ')) {
        return res.status(401).json({ message: 'Access token required. Use Authorization: Bearer <token> or login via POST /auth/login' });
    }
    const token = authHeader.slice(7);
    try {
        const decoded = jwt.verify(token, JWT_SECRET);
        req.authUser = { id: decoded.id, username: decoded.username };
        next();
    } catch (err) {
        if (err.name === 'TokenExpiredError') {
            return res.status(401).json({ message: 'Token expired. Please login again.' });
        }
        return res.status(401).json({ message: 'Invalid or expired token.' });
    }
}

module.exports = { jwtAuth };
