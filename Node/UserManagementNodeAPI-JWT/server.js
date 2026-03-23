const express = require('express');
const cors = require('cors');
const swaggerUi = require('swagger-ui-express');
const swaggerDocument = require('./swagger.json');
require('dotenv').config();

const authRoutes = require('./routes/authRoutes');
const userRoutes = require('./routes/userRoutes');

const app = express();
const PORT = process.env.PORT || 8084;

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument, {
    swaggerOptions: { persistAuthorization: true }
}));

app.use('/auth', authRoutes);
app.use('/api/users', userRoutes);

app.get('/health', (req, res) => {
    res.status(200).json({ status: 'OK', message: 'User Management API is running' });
});

app.use((req, res) => {
    res.status(404).json({ message: 'Route not found' });
});

app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ message: 'Internal server error', error: err.message });
});

app.listen(PORT, () => {
    console.log(`User Management API (JWT) running on http://localhost:${PORT}`);
    console.log(`Swagger UI: http://localhost:${PORT}/api-docs`);
    console.log(`Login: POST http://localhost:${PORT}/auth/login`);
});

module.exports = app;
