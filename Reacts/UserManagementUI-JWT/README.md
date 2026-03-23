# UserManagementUI-JWT

Standalone React UI (based on **UserManagementUI-Simple**) that integrates with **UserManagementNodeAPI-JWT**.

## Features

- Same UI as UserManagementUI-Simple (list, create, edit, view, delete users)
- **Login** via `POST /auth/login` (username/password) → receive JWT token
- All API requests send `Authorization: Bearer <token>`
- Token persisted in localStorage

## Prerequisites

- Node.js 14+
- **UserManagementNodeAPI-JWT** running (e.g. `http://localhost:8084`)

## Setup

1. **Backend:** Start UserManagementNodeAPI-JWT, seed auth user: `node scripts/seed-auth-user.js` (default admin / admin123).

2. **UI:**
   ```bash
   cd UserManagementUI-JWT
   npm install
   ```
   Copy `.env.example` to `.env` and set `REACT_APP_API_BASE_URL` if needed.

3. **Run:**
   ```bash
   npm start
   ```
   Open http://localhost:3000 → sign in (e.g. admin / admin123) → use the app.

## Project structure

Same as UserManagementUI-Simple, plus:

- `src/config/authConfig.js` – API base URL and login URL
- `src/utils/authStore.js` – JWT token for axios
- `src/services/authService.js` – calls `POST /auth/login`
- `src/context/AuthContext.js` – Login state
- `src/components/Login.js`, `AppHeader.js`, `ProtectedRoute.js`
