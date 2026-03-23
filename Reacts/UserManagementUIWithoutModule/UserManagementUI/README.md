# UserManagementUI - React Application

A React-based user interface for the User Management System, built with Bootstrap and Axios for API integration.

## Features

- ✅ User List View with Bootstrap table
- ✅ Create New User form
- ✅ Edit User form
- ✅ View User details
- ✅ Delete User functionality
- ✅ Bootstrap styling
- ✅ Axios for API calls
- ✅ Error handling and loading states
- ✅ Responsive design

## Prerequisites

- Node.js (v14 or higher)
- npm or yarn
- Backend API running on `http://localhost:8080`

## Installation

1. **Install dependencies:**
```bash
npm install
```

or

```bash
yarn install
```

## Running the Application

1. **Start the development server:**
```bash
npm start
```

or

```bash
yarn start
```

2. The application will open in your browser at `http://localhost:3000`

## Project Structure

```
UserManagementUI/
├── public/
│   └── index.html
├── src/
│   ├── components/
│   │   ├── UserList.js      # List all users
│   │   ├── UserForm.js      # Create/Edit user form
│   │   └── UserView.js      # View user details
│   ├── services/
│   │   └── userService.js   # Axios API service
│   ├── App.js               # Main app component with routing
│   ├── index.js             # Entry point
│   ├── index.css            # Global styles
│   └── App.css              # App-specific styles
├── package.json
└── README.md
```

## API Integration

The application uses Axios to communicate with the Spring Boot backend:

- **Base URL:** `http://localhost:8080/api/users`
- **Endpoints:**
  - `GET /api/users` - Get all users
  - `GET /api/users/{id}` - Get user by ID
  - `POST /api/users` - Create user
  - `PUT /api/users/{id}` - Update user
  - `DELETE /api/users/{id}` - Delete user

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
