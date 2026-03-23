# User Management UI - Simple CSS Version

A React-based user management interface built with simple CSS (no Bootstrap). This is a copy of UserManagementUI but uses custom CSS styling instead of Bootstrap.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete users
- **Simple CSS Styling**: Custom CSS without Bootstrap dependencies
- **Responsive Design**: Mobile-friendly layout
- **Dynamic API Configuration**: Automatically detects hostname and configures API endpoints
- **Error Handling**: Comprehensive error handling with user-friendly messages
- **Network Status**: Detects online/offline status

## Prerequisites

- Node.js (v14 or higher)
- npm or yarn
- UserManagement Spring Boot backend running on port 8080

## Installation

1. Clone or navigate to the project directory:
   ```bash
   cd UserManagementUI-Simple
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

## Running the Application

### Development Mode

```bash
npm start
```

The application will start on `http://localhost:3000` (or the next available port).

### Production Build

```bash
npm run build
```

This creates an optimized production build in the `build` folder.

## API Configuration

The application automatically detects the hostname and configures API endpoints:

- **Localhost**: `http://localhost:8080/api/users`
- **Remote**: `http://<hostname>:8080/api/users`

For example, if accessing the UI at `http://103.180.237.120:3000`, the API will be configured to `http://103.180.237.120:8080/api/users`.

## Project Structure

```
UserManagementUI-Simple/
â”œâ”€â”€ public/
â”‚   â””â”€â”€ index.html
â”œâ”€â”€ src/
â”‚   â”œâ”€â”€ components/
â”‚   â”‚   â”œâ”€â”€ ErrorBoundary.js
â”‚   â”‚   â”œâ”€â”€ NetworkStatus.js
â”‚   â”‚   â”œâ”€â”€ UserList.js
â”‚   â”‚   â”œâ”€â”€ UserForm.js
â”‚   â”‚   â”œâ”€â”€ UserView.js
â”‚   â”‚   â””â”€â”€ components.css
â”‚   â”œâ”€â”€ services/
â”‚   â”‚   â””â”€â”€ userService.js
â”‚   â”œâ”€â”€ utils/
â”‚   â”‚   â”œâ”€â”€ apiConfig.js
â”‚   â”‚   â””â”€â”€ preventRefresh.js
â”‚   â”œâ”€â”€ App.js
â”‚   â”œâ”€â”€ App.css
â”‚   â”œâ”€â”€ index.js
â”‚   â””â”€â”€ index.css
â”œâ”€â”€ package.json
â””â”€â”€ README.md
```

## Components

### UserList
Displays a table of all users with options to view, edit, or delete.

### UserForm
Form component for creating and editing users. Supports nested objects (address, company).

### UserView
Detailed view of a single user with all information displayed in cards.

### ErrorBoundary
Catches React component errors and displays a fallback UI.

### NetworkStatus
Displays a notification when the network is offline.

## Styling

All styling is done with custom CSS in:
- `src/index.css` - Global styles
- `src/components/components.css` - Component-specific styles

The CSS includes:
- Button styles (primary, success, danger, warning, info, secondary)
- Form styles
- Table styles
- Card styles
- Responsive design for mobile devices

## Troubleshooting

### Page Refresh Issues
The application includes multiple safeguards to prevent unwanted page refreshes:
- Global error handlers
- Axios interceptors
- Form submission prevention
- Error boundaries

### CORS Issues
Ensure the backend CORS configuration allows requests from your frontend origin.

### API Connection Issues
Check that:
1. The backend is running on port 8080
2. The API endpoints match (`/api/users`)
3. CORS is properly configured on the backend

## Differences from Bootstrap Version

This version uses custom CSS instead of Bootstrap:
- No Bootstrap dependencies
- Custom button, form, table, and card styles
- Simpler, lighter-weight CSS
- Same functionality as Bootstrap version

## License

This project is part of the User Management System.
