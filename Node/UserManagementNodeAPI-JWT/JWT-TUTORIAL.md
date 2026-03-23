# JWT Authentication – Tutorial & Implementation Guide

This document explains **what JWT is**, how it’s used in this project, **step-by-step implementation**, **how to add JWT to your existing UserManagementNodeAPI**, and **sample requests/responses**. You can also test everything via **Swagger UI**.

---

## 1. What Is JWT?

**JWT (JSON Web Token)** is a signed token the server issues after login. The client sends this token on every request instead of username/password.

- **Flow:** Client sends username + password → Server validates → Server returns a **token** → Client sends **Authorization: Bearer &lt;token&gt;** on later requests → Server verifies token and allows access.
- **Benefits:** No password on every request; token can include claims (e.g. user id, role) and expire (e.g. 24h).
- **Format:** `header.payload.signature` (base64-encoded JSON, signed with a secret).

---

## 2. Steps to Implement JWT (From Scratch or Add to Existing Project)

### Step 1: Install dependencies

```bash
npm install jsonwebtoken bcryptjs
```

- `jsonwebtoken`: create and verify JWT.
- `bcryptjs`: hash and verify passwords (same as Basic Auth).

### Step 2: Auth table and seed (same as Basic Auth)

Create `auth_users` table (username, password_hash). Use the same seed script as in the Basic Auth project so you have at least one user (e.g. admin / admin123). Run:

```bash
node scripts/seed-auth-user.js
```

### Step 3: JWT config

Create `config/jwt.js` (or use env only):

```javascript
require('dotenv').config();
const JWT_SECRET = process.env.JWT_SECRET || 'change-in-production';
const JWT_EXPIRES_IN = process.env.JWT_EXPIRES_IN || '24h';
module.exports = { JWT_SECRET, JWT_EXPIRES_IN };
```

Never commit a weak default in production; use a strong `JWT_SECRET` in `.env`.

### Step 4: Auth service

Create `services/AuthService.js`: validate username/password against `auth_users` (using bcrypt.compare). Return user info (e.g. `{ id, username }`) if valid, null otherwise.

### Step 5: Login endpoint (issue token)

Create `routes/authRoutes.js` and `controllers/AuthController.js`:

- **POST /auth/login**  
  - Body: `{ "username": "admin", "password": "admin123" }`  
  - Validate with AuthService.  
  - If valid: `const token = jwt.sign({ id: user.id, username: user.username }, JWT_SECRET, { expiresIn: JWT_EXPIRES_IN });`  
  - Respond: `{ token, type: "Bearer", expiresIn, user: { id, username } }`  
  - If invalid: 401.

Mount the router in `server.js`: `app.use('/auth', authRoutes);`

### Step 6: JWT middleware (protect routes)

Create `middleware/jwtAuth.js`:

1. Read `req.headers.authorization`.
2. If missing or not starting with `"Bearer "`, return 401 (e.g. “Access token required”).
3. Extract token (slice after "Bearer ").
4. `jwt.verify(token, JWT_SECRET)` → if invalid or expired, return 401.
5. Set `req.authUser = decoded` (e.g. `{ id, username }`) and call `next()`.

### Step 7: Protect user routes

In `routes/userRoutes.js`:

```javascript
const { jwtAuth } = require('../middleware/jwtAuth');
router.use(jwtAuth);   // All routes below require valid JWT
// ... GET, POST, PUT, DELETE
```

### Step 8: (Optional) Swagger

- Add `swagger-ui-express` and a `swagger.json`.
- In `components.securitySchemes` add `bearerAuth`: type `http`, scheme `bearer`, bearerFormat `JWT`.
- Document **POST /auth/login** (no security) and all **/api/users** endpoints with `security: [{ bearerAuth: [] }]`.
- In Swagger UI: call **POST /auth/login**, copy the token, then **Authorize** with `Bearer <token>` (or just the token if the UI adds “Bearer” for you).

---

## 3. How to Change in the Same Project (UserManagementNodeAPI)

If you already have **UserManagementNodeAPI** (no auth or with Basic Auth) and want to **switch to JWT**:

| # | Change |
|---|--------|
| 1 | `npm install jsonwebtoken bcryptjs swagger-ui-express` (if not already). |
| 2 | Add `auth_users` table and run `node scripts/seed-auth-user.js` (see Basic Auth or JWT project). |
| 3 | Add `config/jwt.js` (JWT_SECRET, JWT_EXPIRES_IN from env). |
| 4 | Add `services/AuthService.js` (validate username/password from `auth_users`). |
| 5 | Add `controllers/AuthController.js` (login: validate → sign JWT → return token + user). |
| 6 | Add `routes/authRoutes.js` (POST /auth/login) and in `server.js`: `app.use('/auth', authRoutes);` |
| 7 | Add `middleware/jwtAuth.js` (verify Bearer token, set req.authUser). |
| 8 | In `routes/userRoutes.js`: `router.use(jwtAuth);` before your user routes. |
| 9 | (Optional) Add `swagger.json` and mount Swagger UI at `/api-docs`. |

To **keep Basic Auth as well** (e.g. for internal tools), keep both middlewares and apply Basic Auth to a different path or use a single middleware that accepts either Basic or Bearer.

---

## 4. Sample Request and Response

### 4.1 Login – get token

**Request**

```http
POST /auth/login HTTP/1.1
Host: localhost:8084
Content-Type: application/json

{"username":"admin","password":"admin123"}
```

**cURL**

```bash
curl -X POST http://localhost:8084/auth/login \
  -H "Content-Type: application/json" \
  -d "{\"username\":\"admin\",\"password\":\"admin123\"}"
```

**Response (200 OK)**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImlhdCI6MTYxNjAwMDAwMCwiZXhwIjoxNjE2MDg2NDAwfQ.xxxx",
  "type": "Bearer",
  "expiresIn": "24h",
  "user": {
    "id": 1,
    "username": "admin"
  }
}
```

**Response (401 – wrong credentials)**

```json
{
  "message": "Invalid username or password"
}
```

**Response (400 – missing fields)**

```json
{
  "message": "Username and password are required"
}
```

### 4.2 Calling protected endpoints with the token

**Request**

```http
GET /api/users HTTP/1.1
Host: localhost:8084
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

**cURL** (replace `YOUR_TOKEN` with the token from login)

```bash
curl -H "Authorization: Bearer YOUR_TOKEN" http://localhost:8084/api/users
```

**Response (200 OK)** – same as your existing API, e.g. array of users.

**Response (401 – no or invalid token)**

```json
{
  "message": "Access token required. Use Authorization: Bearer <token> or login via POST /auth/login"
}
```

**Response (401 – expired token)**

```json
{
  "message": "Token expired. Please login again."
}
```

---

## 5. Testing with Swagger UI

1. Start server: `npm run dev`
2. Open **http://localhost:8084/api-docs**
3. Call **POST /auth/login** with body `{"username":"admin","password":"admin123"}`.
4. Copy the `token` from the response.
5. Click **Authorize**, paste the token (or “Bearer ” + token if the UI expects the full header value), then Authorize.
6. Call **GET /api/users** or any other protected endpoint; the request will include the Bearer token.

---

## 6. Summary

- **Login:** POST /auth/login with username/password → response includes **token** and **user**.
- **Protected routes:** Send **Authorization: Bearer &lt;token&gt;** on every request.
- **Implementation:** AuthService (validate user) → login endpoint (sign JWT) → jwtAuth middleware (verify token) → apply middleware to user routes.
- **Same project:** Add auth table, AuthService, AuthController, auth routes, JWT config, jwtAuth middleware, and protect user routes; optionally add Swagger.

For a **similar project** that only uses JWT (no Basic Auth), use this repo as reference; for **same project** with both options, add JWT alongside Basic Auth and document which routes use which.
