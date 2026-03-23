# UserManagementUI - React Application

A React-based user interface for the User Management System, with support for **Basic Auth**, **JWT**, and **MongoDB** backends.

## Features

- ✅ User List View with Bootstrap table
- ✅ Create New User form
- ✅ Edit User form
- ✅ View User details
- ✅ Delete User functionality
- ✅ **Login** (Basic Auth or JWT)
- ✅ **Configurable backend**: MySQL (Basic/JWT) or MongoDB API
- ✅ Bootstrap styling, Axios, error handling, responsive design

## Prerequisites

- Node.js (v14 or higher)
- npm or yarn
- One of: UserManagementNodeAPI, UserManagementNodeAPI-BasicAuth, UserManagementNodeAPI-JWT, or UserManagementNodeAPI-MongoDB

## Installation

```bash
npm install
```

Copy `.env.example` to `.env` and set your API URL and auth mode (see **Backend & Auth** below).

## Running the Application

```bash
npm start
```

The app opens at `http://localhost:3000`.

## Backend & Auth

Configure via environment variables (use `.env` or `.env.local`).

| Variable | Description | Examples |
|----------|-------------|----------|
| `REACT_APP_API_BASE_URL` | API base URL (no trailing slash) | `http://localhost:8084` |
| `REACT_APP_AUTH_MODE` | `none` \| `basic` \| `jwt` | `jwt` |

- **No auth (`none`):** Use with original UserManagementNodeAPI or UserManagementNodeAPI-MongoDB (no auth). No login screen.
- **Basic Auth (`basic`):** Use with **UserManagementNodeAPI-BasicAuth**. Login with username/password (e.g. admin / admin123). Every request sends `Authorization: Basic`.
- **JWT (`jwt`):** Use with **UserManagementNodeAPI-JWT** (or any API with `POST /auth/login` and Bearer token). Login once; token is sent on each request and persisted in localStorage.

**MongoDB backend:** Point `REACT_APP_API_BASE_URL` to your MongoDB API (e.g. `http://localhost:8084` if that’s where UserManagementNodeAPI-MongoDB runs). User IDs are strings (ObjectId). If you add JWT to the MongoDB API, set `REACT_APP_AUTH_MODE=jwt`.

## Project Structure

```
UserManagementUI/
├── public/
├── src/
│   ├── config/
│   │   └── authConfig.js    # API URL & auth mode
│   ├── context/
│   │   └── AuthContext.js   # Login state & persistence
│   ├── components/
│   │   ├── UserList.js, UserForm.js, UserView.js
│   │   ├── Login.js, AppHeader.js, ProtectedRoute.js
│   │   └── ...
│   ├── services/
│   │   ├── userService.js
│   │   └── authService.js   # JWT login
│   ├── utils/
│   │   ├── apiConfig.js     # Axios + auth headers
│   │   └── authStore.js
│   ├── App.js, index.js, index.css, App.css
├── .env.example
├── package.json
└── README.md
```

## API Integration

- **Base URL:** From `REACT_APP_API_BASE_URL` (e.g. `http://localhost:8084`).
- **Endpoints:** `GET/POST /api/users`, `GET/PUT/DELETE /api/users/:id`, etc.
- **JWT:** `POST /auth/login` with `{ username, password }` → returns `{ token, user }`. Token is sent as `Authorization: Bearer <token>`.

## Components

### UserList
- Displays all users in a Bootstrap table
- Actions: View, Edit, Delete
- Loading and error states

### UserForm
- Create new users or edit existing ones
- Form validation
- Handles nested objects (Address, Geo, Company)

### UserView
- View detailed user information
- Displays all user data including nested objects

## Styling

- Bootstrap 5.2.3 for responsive design
- Custom CSS for enhanced UI
- Gradient headers and card layouts

## Available Scripts

- `npm start` - Start development server
- `npm build` - Build for production
- `npm test` - Run tests
- `npm eject` - Eject from Create React App

## Notes

- Make sure the backend API is running before starting the frontend
- The proxy is configured in `package.json` to handle CORS
- All API calls are handled through the `userService.js` file
