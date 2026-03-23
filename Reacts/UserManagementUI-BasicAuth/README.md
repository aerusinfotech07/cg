# UserManagementUI-BasicAuth

Standalone React UI (based on **UserManagementUI-Simple**) that integrates with **UserManagementNodeAPI-BasicAuth**.

## Features

- Same UI as UserManagementUI-Simple (list, create, edit, view, delete users)
- **Login** with username/password (HTTP Basic Auth)
- All API requests send `Authorization: Basic <base64(username:password)>`
- Credentials persisted in localStorage (re-login after refresh optional)

## Prerequisites

- Node.js 14+
- **UserManagementNodeAPI-BasicAuth** running (e.g. `http://localhost:8084`)

## Setup

1. **Backend:** Start UserManagementNodeAPI-BasicAuth, seed auth user: `node scripts/seed-auth-user.js` (default admin / admin123).

2. **UI:**
   ```bash
   cd UserManagementUI-BasicAuth
   npm install
   ```
   Copy `.env.example` to `.env` and set `REACT_APP_API_BASE_URL` if your API is not on `http://localhost:8084`.

3. **Run:**
   ```bash
   npm start
   ```
   Open http://localhost:3000 → sign in (e.g. admin / admin123) → use the app.

## Project structure

Same as UserManagementUI-Simple, plus:

- `src/config/authConfig.js` – API base URL
- `src/utils/authStore.js` – Basic Auth credentials for axios
- `src/context/AuthContext.js` – Login state
- `src/components/Login.js`, `AppHeader.js`, `ProtectedRoute.js`
