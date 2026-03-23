# User Management API – Basic Authentication

Same as **UserManagementNodeAPI** with **HTTP Basic Authentication** and **Swagger UI** for testing.

## Quick start

1. **Database:** Create DB and run `database/init.sql`, then seed an auth user:
   ```bash
   node scripts/seed-auth-user.js
   ```
   Default: username `admin`, password `admin123`.

2. **Env:** Copy `.env.example` to `.env` and set MySQL credentials.

3. **Run:**
   ```bash
   npm install
   npm run dev
   ```

4. **Swagger UI:** Open http://localhost:8084/api-docs → **Authorize** (admin / admin123) → try endpoints.

5. **cURL:** `curl -u admin:admin123 http://localhost:8084/api/users`

## Docs

- **AUTH-IMPLEMENTATION-GUIDE.md** – Steps to implement Basic Auth and how to add it to the same (existing) project; sample request/response; Swagger testing.

## Endpoints

- `GET /health` – no auth
- `GET/POST /api/users`, `GET/PUT/DELETE /api/users/:id`, `GET /api/users/username/:username`, `GET /api/users/email/:email` – **require Basic Auth**
