const userService = require('../services/UserService');
const { validationResult } = require('express-validator');

class UserController {
    async getAllUsers(req, res) {
        try {
            const users = await userService.getAllUsers();
            res.status(200).json(users);
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    }

    //http://localhost:8080/um/users?id=101&email=dsdfef@gmail.com
    async getUserById(req, res) {
        try {
            const id = parseInt(req.params.id);
            const user = await userService.getUserById(id);
            if (user) {
                res.status(200).json(user);
            } else {
                res.status(404).json({ message: `User not found with id: ${id}` });
            }
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    }

    async getUserByUsername(req, res) {
        try {
            const username = req.params.username;
            const user = await userService.getUserByUsername(username);
            if (user) {
                res.status(200).json(user);
            } else {
                res.status(404).json({ message: `User not found with username: ${username}` });
            }
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    }

    async getUserByEmail(req, res) {
        try {
            const email = req.params.email;
            const user = await userService.getUserByEmail(email);
            if (user) {
                res.status(200).json(user);
            } else {
                res.status(404).json({ message: `User not found with email: ${email}` });
            }
        } catch (error) {
            res.status(500).json({ message: error.message });
        }
    }

    async createUser(req, res) {
        try {
            const errors = validationResult(req);
            if (!errors.isEmpty()) {
                return res.status(400).json({ errors: errors.array() });
            }

            const user = await userService.createUser(req.body);
            res.status(201).json(user);
        } catch (error) {
            res.status(400).json({ message: error.message });
        }
    }

    async updateUser(req, res) {
        try {
            const errors = validationResult(req);
            if (!errors.isEmpty()) {
                return res.status(400).json({ errors: errors.array() });
            }

            const id = parseInt(req.params.id);
            const user = await userService.updateUser(id, req.body);
            if (user) {
                res.status(200).json(user);
            } else {
                res.status(404).json({ message: `User not found with id: ${id}` });
            }
        } catch (error) {
            if (error.message.includes('not found')) {
                res.status(404).json({ message: error.message });
            } else {
                res.status(400).json({ message: error.message });
            }
        }
    }

    async deleteUser(req, res) {
        try {
            const id = parseInt(req.params.id);
            await userService.deleteUser(id);
            res.status(200).json({ message: 'User deleted successfully' });
        } catch (error) {
            if (error.message.includes('not found')) {
                res.status(404).json({ message: error.message });
            } else {
                res.status(500).json({ message: error.message });
            }
        }
    }
}

module.exports = new UserController();
