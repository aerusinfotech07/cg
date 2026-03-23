# UserManagementNodeAPI

User Management REST API built with **Node.js** and **Express**, following the same pattern as the Java Spring Boot UserManagement project.

## Stack

- Node.js (v14+)
- Express.js 4.x
- MySQL2 (for MySQL database)
- Express Validator (for input validation)
- CORS enabled

## Project Structure

```
UserManagementNodeAPI/
├── config/
│   └── database.js          # MySQL connection pool
├── models/                  # Domain models
│   ├── User.js
│   ├── Address.js
│   ├── Geo.js
│   └── Company.js
├── services/                # Business logic layer
│   └── UserService.js
├── controllers/             # Request handlers
│   └── UserController.js
├── routes/                  # Route definitions
│   └── userRoutes.js
├── database/
│   └── init.sql             # Database schema
├── server.js                # Main application entry
├── package.json
└── .env.example
```

## Architecture Layers

1. **Models** (`models/`): Domain models representing database entities
   - User, Address, Geo, Company

2. **Services** (`services/`): Business logic layer
   - UserService handles CRUD operations and business rules

3. **Controllers** (`controllers/`): Request/response handlers
   - UserController processes HTTP requests and calls services

4. **Routes** (`routes/`): API endpoint definitions
   - userRoutes defines REST endpoints with validation

## Prerequisites

- **Node.js** 14+ and npm installed
- **MySQL** 5.7+ installed and running
- **IDE** (VS Code, WebStorm, etc.) optional

## Implementation Steps

### Step 1: Install dependencies

```bash
cd UserManagementNodeAPI
npm install
```

### Step 2: Database setup

1. Create MySQL database:

```sql
CREATE DATABASE usermanagement;
```

2. Run the initialization script:

```bash
mysql -u root -p usermanagement < database/init.sql
```

Or execute `database/init.sql` manually in MySQL client.

### Step 3: Configure environment

1. Copy `.env.example` to `.env`:

```bash
cp .env.example .env
```

2. Edit `.env` and set your MySQL credentials:

```env
PORT=8084
DB_HOST=localhost
DB_PORT=3306
DB_USER=root
DB_PASSWORD=root
DB_NAME=usermanagement
```

### Step 4: Run the application

**Development mode (with auto-reload):**

```bash
npm run dev
```

**Production mode:**

```bash
npm start
```

The API will start on **http://localhost:8084**

### Step 5: Verify

- Health check: **http://localhost:8084/health**
- API: **http://localhost:8084/api/users**

## API Endpoints

All endpoints are under `/api/users`:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/:id` | Get user by ID |
| GET | `/api/users/username/:username` | Get user by username |
| GET | `/api/users/email/:email` | Get user by email |
| POST | `/api/users` | Create a new user |
| PUT | `/api/users/:id` | Update user by ID |
| DELETE | `/api/users/:id` | Delete user by ID |

## Example Requests

### Create User

```bash
curl -X POST http://localhost:8084/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
  }'
```

### Get All Users

```bash
curl http://localhost:8084/api/users
```

### Get User by ID

```bash
curl http://localhost:8084/api/users/1
```

### Update User

```bash
curl -X PUT http://localhost:8084/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Name",
    "username": "Bret",
    "email": "updated@example.com"
  }'
```

### Delete User

```bash
curl -X DELETE http://localhost:8084/api/users/1
```

## Features

- ✅ Full CRUD operations (Create, Read, Update, Delete)
- ✅ Layered architecture (Models, Services, Controllers, Routes)
- ✅ MySQL database integration
- ✅ Input validation with express-validator
- ✅ Error handling
- ✅ RESTful API design
- ✅ Nested object support (Address with Geo, Company)
- ✅ Transaction support for data integrity
- ✅ CORS enabled for cross-origin requests

## Technologies Used

- Node.js
- Express.js 4.18.2
- MySQL2 3.6.5
- Express Validator 7.0.1
- CORS 2.8.5
- dotenv 16.3.1

## Notes

- The database schema is created via `database/init.sql` (unlike Spring Boot's auto-create).
- All nested entities (Address, Geo, Company) are handled with transactions.
- Username and Email have unique constraints at the database level.
- The API includes proper error handling and validation.
- Uses connection pooling for efficient database access.

---

## Tutorial: Building from Scratch

This section provides a step-by-step guide to build the entire project from scratch for learning purposes.

### Prerequisites Check

Before starting, ensure you have:
- Node.js 14+ installed (`node --version`)
- npm installed (`npm --version`)
- MySQL 5.7+ installed and running
- A code editor (VS Code recommended)

### Step 1: Initialize the Project

1. Create a new directory:
```bash
mkdir UserManagementNodeAPI
cd UserManagementNodeAPI
```

2. Initialize npm project:
```bash
npm init -y
```

This creates `package.json` with default values.

3. Edit `package.json` to add project details:
```json
{
  "name": "usermanagement-node-api",
  "version": "1.0.0",
  "description": "User Management REST API using Node.js and Express",
  "main": "server.js",
  "scripts": {
    "start": "node server.js",
    "dev": "nodemon server.js"
  }
}
```

### Step 2: Install Dependencies

Install required packages:

```bash
npm install express mysql2 cors dotenv express-validator
npm install --save-dev nodemon
```

**What each package does:**
- `express`: Web framework for Node.js
- `mysql2`: MySQL client with promise support
- `cors`: Enable Cross-Origin Resource Sharing
- `dotenv`: Load environment variables from `.env` file
- `express-validator`: Input validation middleware
- `nodemon`: Auto-restart server during development

### Step 3: Set Up Environment Configuration

1. Create `.env` file:
```bash
touch .env
```

2. Add configuration:
```env
PORT=8084
DB_HOST=localhost
DB_PORT=3306
DB_USER=root
DB_PASSWORD=root
DB_NAME=usermanagement
```

3. Create `.gitignore`:
```
node_modules/
.env
*.log
.DS_Store
```

### Step 4: Create Database Schema

1. Create `database` directory:
```bash
mkdir database
```

2. Create `database/init.sql`:
```sql
USE usermanagement;

CREATE TABLE IF NOT EXISTS geo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    lat VARCHAR(50) NOT NULL,
    lng VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    suite VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    zipcode VARCHAR(50) NOT NULL,
    geo_id BIGINT,
    FOREIGN KEY (geo_id) REFERENCES geo(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS company (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    catch_phrase VARCHAR(500),
    bs VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(50),
    website VARCHAR(255),
    address_id BIGINT,
    company_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL,
    FOREIGN KEY (company_id) REFERENCES company(id) ON DELETE SET NULL
);

CREATE INDEX idx_username ON users(username);
CREATE INDEX idx_email ON users(email);
```

3. Create database and run script:
```bash
mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS usermanagement;"
mysql -u root -p usermanagement < database/init.sql
```

### Step 5: Create Database Connection

1. Create `config` directory:
```bash
mkdir config
```

2. Create `config/database.js`:
```javascript
const mysql = require('mysql2/promise');
require('dotenv').config();

const pool = mysql.createPool({
    host: process.env.DB_HOST || 'localhost',
    port: process.env.DB_PORT || 3306,
    user: process.env.DB_USER || 'root',
    password: process.env.DB_PASSWORD || 'root',
    database: process.env.DB_NAME || 'usermanagement',
    waitForConnections: true,
    connectionLimit: 10,
    queueLimit: 0
});

// Test connection
pool.getConnection()
    .then(connection => {
        console.log('Connected to MySQL database');
        connection.release();
    })
    .catch(err => {
        console.error('Database connection error:', err.message);
    });

module.exports = pool;
```

**Explanation:** This creates a connection pool for efficient database access. The pool manages multiple connections automatically.

### Step 6: Create Domain Models

1. Create `models` directory:
```bash
mkdir models
```

2. Create `models/Geo.js`:
```javascript
class Geo {
    constructor(data) {
        this.id = data.id || null;
        this.lat = data.lat || null;
        this.lng = data.lng || null;
    }

    static fromDbRow(row) {
        if (!row) return null;
        return new Geo({
            id: row.geo_id,
            lat: row.geo_lat,
            lng: row.geo_lng
        });
    }

    toDbValues() {
        return {
            lat: this.lat,
            lng: this.lng
        };
    }
}

module.exports = Geo;
```

3. Create `models/Company.js`:
```javascript
class Company {
    constructor(data) {
        this.id = data.id || null;
        this.name = data.name || null;
        this.catchPhrase = data.catchPhrase || null;
        this.bs = data.bs || null;
    }

    static fromDbRow(row) {
        if (!row) return null;
        return new Company({
            id: row.company_id,
            name: row.company_name,
            catchPhrase: row.company_catch_phrase,
            bs: row.company_bs
        });
    }

    toDbValues() {
        return {
            name: this.name,
            catch_phrase: this.catchPhrase,
            bs: this.bs
        };
    }
}

module.exports = Company;
```

4. Create `models/Address.js`:
```javascript
const Geo = require('./Geo');

class Address {
    constructor(data) {
        this.id = data.id || null;
        this.street = data.street || null;
        this.suite = data.suite || null;
        this.city = data.city || null;
        this.zipcode = data.zipcode || null;
        this.geo = data.geo ? new Geo(data.geo) : null;
    }

    static fromDbRow(row) {
        if (!row) return null;
        const address = new Address({
            id: row.address_id,
            street: row.address_street,
            suite: row.address_suite,
            city: row.address_city,
            zipcode: row.address_zipcode
        });
        if (row.geo_id) {
            address.geo = Geo.fromDbRow(row);
        }
        return address;
    }

    toDbValues() {
        return {
            street: this.street,
            suite: this.suite,
            city: this.city,
            zipcode: this.zipcode
        };
    }
}

module.exports = Address;
```

5. Create `models/User.js`:
```javascript
const Address = require('./Address');
const Company = require('./Company');

class User {
    constructor(data) {
        this.id = data.id || null;
        this.name = data.name || null;
        this.username = data.username || null;
        this.email = data.email || null;
        this.phone = data.phone || null;
        this.website = data.website || null;
        this.address = data.address ? new Address(data.address) : null;
        this.company = data.company ? new Company(data.company) : null;
    }

    static fromDbRow(row) {
        if (!row) return null;
        const user = new User({
            id: row.user_id,
            name: row.user_name,
            username: row.user_username,
            email: row.user_email,
            phone: row.user_phone,
            website: row.user_website
        });
        if (row.address_id) {
            user.address = Address.fromDbRow(row);
        }
        if (row.company_id) {
            user.company = Company.fromDbRow(row);
        }
        return user;
    }

    toDbValues() {
        return {
            name: this.name,
            username: this.username,
            email: this.email,
            phone: this.phone,
            website: this.website
        };
    }
}

module.exports = User;
```

**Explanation:** Models represent domain entities. `fromDbRow()` converts database rows to objects, `toDbValues()` prepares data for database insertion.

### Step 7: Create Service Layer

1. Create `services` directory:
```bash
mkdir services
```

2. Create `services/UserService.js` (start with basic methods):

```javascript
const pool = require('../config/database');
const User = require('../models/User');

class UserService {
    async getAllUsers() {
        const query = `
            SELECT 
                u.id as user_id, u.name as user_name, u.username as user_username, 
                u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite,
                a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, 
                c.catch_phrase as company_catch_phrase, c.bs as company_bs
            FROM users u
            LEFT JOIN address a ON u.address_id = a.id
            LEFT JOIN geo g ON a.geo_id = g.id
            LEFT JOIN company c ON u.company_id = c.id
            ORDER BY u.id
        `;
        const [rows] = await pool.execute(query);
        return rows.map(row => User.fromDbRow(row));
    }

    async getUserById(id) {
        const query = `
            SELECT 
                u.id as user_id, u.name as user_name, u.username as user_username, 
                u.email as user_email, u.phone as user_phone, u.website as user_website,
                a.id as address_id, a.street as address_street, a.suite as address_suite,
                a.city as address_city, a.zipcode as address_zipcode,
                g.id as geo_id, g.lat as geo_lat, g.lng as geo_lng,
                c.id as company_id, c.name as company_name, 
                c.catch_phrase as company_catch_phrase, c.bs as company_bs
            FROM users u
            LEFT JOIN address a ON u.address_id = a.id
            LEFT JOIN geo g ON a.geo_id = g.id
            LEFT JOIN company c ON u.company_id = c.id
            WHERE u.id = ?
        `;
        const [rows] = await pool.execute(query, [id]);
        return rows.length > 0 ? User.fromDbRow(rows[0]) : null;
    }

    // Add other methods: getUserByUsername, getUserByEmail, createUser, updateUser, deleteUser
    // (See full implementation in the actual file)
}

module.exports = new UserService();
```

**Explanation:** Services contain business logic. They interact with the database and return domain objects.

### Step 8: Create Controller Layer

1. Create `controllers` directory:
```bash
mkdir controllers
```

2. Create `controllers/UserController.js`:
```javascript
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

    // Add other methods: getUserByUsername, getUserByEmail, createUser, updateUser, deleteUser
}

module.exports = new UserController();
```

**Explanation:** Controllers handle HTTP requests/responses and call services. They don't contain business logic.

### Step 9: Create Routes

1. Create `routes` directory:
```bash
mkdir routes
```

2. Create `routes/userRoutes.js`:
```javascript
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
```

**Explanation:** Routes define API endpoints and apply validation middleware before calling controllers.

### Step 10: Create Main Server File

Create `server.js`:
```javascript
const express = require('express');
const cors = require('cors');
require('dotenv').config();

const userRoutes = require('./routes/userRoutes');

const app = express();
const PORT = process.env.PORT || 8084;

// Middleware
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Routes
app.use('/api/users', userRoutes);

// Health check
app.get('/health', (req, res) => {
    res.status(200).json({ status: 'OK', message: 'User Management API is running' });
});

// 404 handler
app.use((req, res) => {
    res.status(404).json({ message: 'Route not found' });
});

// Error handler
app.use((err, req, res, next) => {
    console.error(err.stack);
    res.status(500).json({ message: 'Internal server error', error: err.message });
});

// Start server
app.listen(PORT, () => {
    console.log(`User Management API server running on http://localhost:${PORT}`);
    console.log(`Health check: http://localhost:${PORT}/health`);
    console.log(`API endpoints: http://localhost:${PORT}/api/users`);
});

module.exports = app;
```

**Explanation:** This is the entry point. It sets up Express, middleware, routes, and error handlers.

### Step 11: Test the Application

1. Start the server:
```bash
npm run dev
```

2. Test health endpoint:
```bash
curl http://localhost:8084/health
```

3. Test getting users (should return empty array initially):
```bash
curl http://localhost:8084/api/users
```

4. Create a test user:
```bash
curl -X POST http://localhost:8084/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "username": "johndoe",
    "email": "john@example.com"
  }'
```

5. Verify the user was created:
```bash
curl http://localhost:8084/api/users
```

### Step 12: Complete the Service Methods

Go back to `services/UserService.js` and implement:
- `getUserByUsername()`
- `getUserByEmail()`
- `existsByUsername()` and `existsByEmail()` (helper methods)
- `createUser()` (with transaction support for nested objects)
- `updateUser()` (with transaction support)
- `deleteUser()` (with cleanup of related records)

### Step 13: Complete the Controller Methods

Add remaining methods to `controllers/UserController.js`:
- `getUserByUsername()`
- `getUserByEmail()`
- `createUser()`
- `updateUser()`
- `deleteUser()`

### Step 14: Testing All Endpoints

Test each endpoint:
- GET all users
- GET by ID
- GET by username
- GET by email
- POST (create)
- PUT (update)
- DELETE

### Common Issues and Solutions

1. **"Cannot find module" errors**: Run `npm install`
2. **Database connection fails**: Check `.env` file and MySQL is running
3. **Port already in use**: Change `PORT` in `.env` or stop the process using port 8084
4. **Validation errors**: Check request body matches expected format

### Next Steps

- Add error logging
- Add request logging middleware
- Add API documentation (Swagger)
- Add unit tests
- Add authentication (JWT/Basic Auth)

For full notes and troubleshooting, see the parent **IMPLEMENTATION.md**.
