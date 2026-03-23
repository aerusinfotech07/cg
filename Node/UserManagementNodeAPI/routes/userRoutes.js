const express = require('express');
const router = express.Router();
const userController = require('../controllers/UserController');
const { body } = require('express-validator');

// Validation rules
const userValidation = [
    body('name').notEmpty().withMessage('Name is required'),
    body('username').notEmpty().withMessage('Username is required'),
    body('email').isEmail().withMessage('Email should be valid').notEmpty().withMessage('Email is required')
];

// Routes
router.get('/', userController.getAllUsers.bind(userController));
router.get('/:id', userController.getUserById.bind(userController));
router.get('/username/:username', userController.getUserByUsername.bind(userController));
router.get('/email/:email', userController.getUserByEmail.bind(userController));
router.post('/', userValidation, userController.createUser.bind(userController));
router.put('/:id', userValidation, userController.updateUser.bind(userController));
router.delete('/:id', userController.deleteUser.bind(userController));

module.exports = router;
