# UserManagementUI-MongoDB

Standalone React UI (based on **UserManagementUI-Simple**) that integrates with **UserManagementNodeAPI-MongoDB**.

## Features

- Same UI as UserManagementUI-Simple (list, create, edit, view, delete users)
- **No login** – MongoDB API has no auth by default
- User **IDs are strings** (MongoDB ObjectId); the UI uses them in routes as-is

## Prerequisites

- Node.js 14+
- **UserManagementNodeAPI-MongoDB** running (e.g. `http://localhost:8084`)

## Setup

1. **Backend:** Start UserManagementNodeAPI-MongoDB (`npm run dev` in that project).

2. **UI:**
   ```bash
   cd UserManagementUI-MongoDB
   npm install
   ```
   Copy `.env.example` to `.env` and set `REACT_APP_API_BASE_URL` if your API is not on `http://localhost:8084`.

3. **Run:**
   ```bash
   npm start
   ```
   Open http://localhost:3000 – you go straight to the user list (no login).

## Project structure

Same as UserManagementUI-Simple (no auth, no Login/ProtectedRoute/AppHeader):

- `src/utils/apiConfig.js` – API base URL only (default `http://localhost:8084`)
- `src/services/userService.js`
- `src/components/` – UserList, UserForm, UserView, ErrorBoundary, NetworkStatus
