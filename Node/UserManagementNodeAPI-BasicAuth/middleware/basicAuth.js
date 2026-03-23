const authService = require('../services/AuthService');

/**
 * HTTP Basic Authentication middleware.
 * Expects header: Authorization: Basic <base64(username:password)>
 */
async function basicAuth(req, res, next) {
    const authHeader = req.headers.authorization;
    if (!authHeader || !authHeader.startsWith('Basic ')) {
        res.setHeader('WWW-Authenticate', 'Basic realm="User Management API"');
        return res.status(401).json({ message: 'Authentication required. Use Basic Auth (username + password).' });
    }
    const base64Credentials = authHeader.slice(6);
    let credentials;
    try {
        credentials = Buffer.from(base64Credentials, 'base64').toString('utf8');
    } catch {
        return res.status(401).json({ message: 'Invalid Authorization header.' });
    }
    const [username, password] = credentials.split(':');
    const user = await authService.validateUser(username, password);
    if (!user) {
        res.setHeader('WWW-Authenticate', 'Basic realm="User Management API"');
        return res.status(401).json({ message: 'Invalid username or password.' });
    }
    req.authUser = user;
    next();
}

module.exports = basicAuth;
