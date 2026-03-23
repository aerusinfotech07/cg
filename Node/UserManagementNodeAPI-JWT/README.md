# User Management API – JWT Authentication

Same as **UserManagementNodeAPI** with **JWT authentication** and **Swagger UI**.

## Quick start

1. **Database:** Create DB, run `database/init.sql`, then seed an auth user:
   ```bash
   node scripts/seed-auth-user.js
   ```
   Default: username `admin`, password `admin123`.

2. **Env:** Copy `.env.example` to `.env`. Set MySQL and optionally `JWT_SECRET`, `JWT_EXPIRES_IN`.

3. **Run:**
   ```bash
   npm install
   npm run dev
   ```

4. **Get token:**  
   `POST http://localhost:8084/auth/login`  
   Body: `{"username":"admin","password":"admin123"}`  
   Use the `token` from the response in: `Authorization: Bearer <token>`.

5. **Swagger UI:**  
   Open http://localhost:8084/api-docs → run **POST /auth/login** → copy token → **Authorize** (paste token) → try **GET /api/users** and others.

## Docs

- **JWT-TUTORIAL.md** – What is JWT, steps to implement, how to add JWT to the same project, sample request/response, Swagger testing.

## Endpoints

- `GET /health` – no auth  
- `POST /auth/login` – body: `{ "username", "password" }` → returns `{ token, type, expiresIn, user }`  
- `GET/POST /api/users`, `GET/PUT/DELETE /api/users/:id`, `GET /api/users/username/:username`, `GET /api/users/email/:email` – **require JWT** (Header: `Authorization: Bearer <token>`)
