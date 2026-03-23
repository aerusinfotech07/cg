# Basic Authentication – Implementation Guide

This guide explains how Basic Auth is implemented in this project and **how to add it to your existing UserManagementNodeAPI** (or any similar Express + MySQL app).

---

## 1. What Is HTTP Basic Authentication?

- The client sends **username** and **password** on every request.
- Header format: `Authorization: Basic <base64(username:password)>`
- The server decodes the header, validates credentials, and allows or denies access (e.g. 401 Unauthorized).

**Pros:** Simple, no tokens, works in browsers and tools.  
**Cons:** Credentials sent every time; use **HTTPS** in production.

---

## 2. Steps to Implement (From Scratch or Add to Existing Project)

### Step 1: Install dependency

```bash
npm install bcryptjs
```

Use `bcryptjs` to hash and verify passwords (never store plain text).

### Step 2: Add auth table and seed script

**Database:** Create table for login users (separate from your business `users` table).

```sql
CREATE TABLE IF NOT EXISTS auth_users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX idx_auth_username ON auth_users(username);
```

**Seed script** (e.g. `scripts/seed-auth-user.js`): hash password with bcrypt and insert/update one user:

```javascript
require('dotenv').config({ path: require('path').join(__dirname, '..', '.env') });
const bcrypt = require('bcryptjs');
const mysql = require('mysql2/promise');

const username = process.env.AUTH_USERNAME || 'admin';
const password = process.env.AUTH_PASSWORD || 'admin123';

async function seed() {
    const pool = mysql.createPool({ /* same as config/database.js */ });
    const hash = bcrypt.hashSync(password, 10);
    await pool.execute(
        'INSERT INTO auth_users (username, password_hash) VALUES (?, ?) ON DUPLICATE KEY UPDATE password_hash = ?',
        [username, hash, hash]
    );
    console.log(`Auth user "${username}" created. Password: ${password}`);
    await pool.end();
}
seed().catch(err => { console.error(err); process.exit(1); });
```

Run after DB is ready: `node scripts/seed-auth-user.js`

### Step 3: Auth service

Create `services/AuthService.js` that loads the user by `username` and checks password with `bcrypt.compare(password, row.password_hash)`.

### Step 4: Basic Auth middleware

Create `middleware/basicAuth.js`:

1. Read `req.headers.authorization`.
2. If missing or not starting with `"Basic "`, respond with **401** and header `WWW-Authenticate: Basic realm="..."`.
3. Decode the base64 part to get `username:password`.
4. Call AuthService to validate; if invalid, return 401.
5. If valid, set `req.authUser = { id, username }` and call `next()`.

### Step 5: Protect routes

In your user routes file:

```javascript
const basicAuth = require('../middleware/basicAuth');
router.use(basicAuth);   // Apply to all routes in this router
// ... existing GET, POST, PUT, DELETE
```

### Step 6: (Optional) Swagger

- Add `swagger-ui-express` and a `swagger.json` that defines `securitySchemes.basicAuth` (type `http`, scheme `basic`).
- Mount Swagger UI at e.g. `/api-docs` and enable "Authorize" so you can test with username/password from the UI.

---

## 3. How to Change in the Same Project (UserManagementNodeAPI)

If you already have **UserManagementNodeAPI** without auth:

| # | Change |
|---|--------|
| 1 | `npm install bcryptjs swagger-ui-express` |
| 2 | Add `auth_users` table (see Step 2 above) to your DB and run `database/init.sql` (or alter script). |
| 3 | Add `scripts/seed-auth-user.js` and run it once. |
| 4 | Add `services/AuthService.js` and `middleware/basicAuth.js` (see this project’s files). |
| 5 | In `routes/userRoutes.js`: `const basicAuth = require('../middleware/basicAuth');` and `router.use(basicAuth);` before your routes. |
| 6 | In `server.js`: mount Swagger with `swagger-ui-express` and your `swagger.json` (optional). |

No change is required in controllers or UserService; only the route file and new auth layer.

---

## 4. Sample Request and Response

### Request (with Basic Auth)

```http
GET /api/users HTTP/1.1
Host: localhost:8084
Authorization: Basic YWRtaW46YWRtaW4xMjM=
```

- `YWRtaW46YWRtaW4xMjM=` is Base64 for `admin:admin123`.

**Using cURL:**

```bash
curl -u admin:admin123 http://localhost:8084/api/users
```

**Using Postman:**  
Auth tab → Type: Basic Auth → Username: `admin`, Password: `admin123`.

### Response (200 OK)

```json
[
  {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "address": {
      "id": 1,
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": { "id": 1, "lat": "-37.3159", "lng": "81.1496" }
    },
    "company": {
      "id": 1,
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
  }
]
```

### Response (401 Unauthorized – wrong or missing credentials)

```json
{
  "message": "Invalid username or password."
}
```

Or, if the `Authorization` header is missing:

```json
{
  "message": "Authentication required. Use Basic Auth (username + password)."
}
```

---

## 5. Testing with Swagger UI

1. Start the server: `npm run dev`
2. Open **http://localhost:8084/api-docs**
3. Click **Authorize**
4. Enter username: `admin`, password: `admin123` → Authorize
5. Call any `/api/users` endpoint from the UI; the request will include the Basic Auth header automatically.

---

## 6. Summary

- **Basic Auth** = `Authorization: Basic <base64(user:pass)>` on each request.
- Store only **hashed** passwords (bcrypt) in `auth_users`; validate in middleware.
- Add **middleware** to the user router so all `/api/users` routes require auth.
- Use **Swagger** with `securitySchemes.basicAuth` to test from the UI.
