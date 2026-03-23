# UserManagementNodeAPI (MongoDB)

User Management REST API built with **Node.js**, **Express**, and **MongoDB**. Same API and behavior as the MySQL-based UserManagementNodeAPI, using MongoDB as the database.

## Stack

- Node.js (v14+)
- Express.js 4.x
- MongoDB (native `mongodb` driver)
- Express Validator (for input validation)
- CORS enabled

## Project Structure

```
UserManagementNodeAPI-MongoDB/
├── config/
│   └── database.js          # MongoDB connection and index setup
├── models/
│   ├── User.js
│   ├── Address.js
│   ├── Geo.js
│   └── Company.js
├── services/
│   └── UserService.js
├── controllers/
│   └── UserController.js
├── routes/
│   └── userRoutes.js
├── server.js                 # Main application entry
├── package.json
└── .env.example
```

## Data Model

- **users** collection: one document per user.
- **address** and **company** are embedded subdocuments (no separate collections).
- **address.geo** is embedded inside address.
- Unique indexes on `username` and `email` are created on startup.

## Prerequisites

- **Node.js** 14+ and npm
- **MongoDB** (local or Atlas) installed and running

## Setup

### 1. Install dependencies

```bash
cd UserManagementNodeAPI-MongoDB
npm install
```

### 2. Environment

Copy `.env.example` to `.env` and adjust if needed:

```bash
cp .env.example .env
```

Example `.env`:

```env
PORT=8084
MONGODB_URI=mongodb://localhost:27017
DB_NAME=usermanagement
```

For MongoDB Atlas use:

```env
MONGODB_URI=mongodb+srv://user:password@cluster.mongodb.net/
DB_NAME=usermanagement
```

### 3. Run the application

**Development (with auto-reload):**

```bash
npm run dev
```

**Production:**

```bash
npm start
```

API base: **http://localhost:8084**

### 4. Verify

- Health: **http://localhost:8084/health**
- Users API: **http://localhost:8084/api/users**

## API Endpoints

Same as the MySQL version:

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/:id` | Get user by ID (MongoDB ObjectId string) |
| GET | `/api/users/username/:username` | Get user by username |
| GET | `/api/users/email/:email` | Get user by email |
| POST | `/api/users` | Create a new user |
| PUT | `/api/users/:id` | Update user by ID |
| DELETE | `/api/users/:id` | Delete user by ID |

## Example: Create User

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
      "geo": { "lat": "-37.3159", "lng": "81.1496" }
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

Response includes an `id` field (string, MongoDB ObjectId hex). Use this `id` for GET/PUT/DELETE by ID.

## Differences from MySQL Version

- **IDs**: User `id` is a string (MongoDB ObjectId hex), not a number.
- **Schema**: No SQL schema file; a single `users` collection with embedded address (and geo) and company.
- **Config**: Use `MONGODB_URI` and `DB_NAME` instead of MySQL host/port/user/password/database.

## Technologies

- Node.js
- Express 4.18.x
- mongodb 6.x
- Express Validator 7.x
- CORS, dotenv
