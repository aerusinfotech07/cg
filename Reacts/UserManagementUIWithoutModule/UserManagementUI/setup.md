# Setup Instructions for UserManagementUI

## Fix for Webpack Dev Server Error

If you encounter the error:
```
Invalid options object. Dev Server has been initialized using an options object that does not match the API schema.
 - options.allowedHosts[0] should be a non-empty string.
```

### Solution 1: Update Dependencies

1. Delete `node_modules` folder and `package-lock.json`:
```bash
rm -rf node_modules package-lock.json
```

2. Install dependencies again:
```bash
npm install
```

### Solution 2: Use Yarn (Alternative)

If npm continues to have issues, try using yarn:

1. Install yarn (if not already installed):
```bash
npm install -g yarn
```

2. Install dependencies:
```bash
yarn install
```

3. Start the app:
```bash
yarn start
```

### Solution 3: Update Node.js

Make sure you're using Node.js version 14 or higher:
```bash
node --version
```

If you need to update Node.js, download it from https://nodejs.org/

### Solution 4: Clear Cache

Try clearing npm cache:
```bash
npm cache clean --force
```

Then reinstall:
```bash
npm install
npm start
```

## After Setup

Once the app starts successfully, it will be available at:
- **Frontend:** http://localhost:3000
- **Backend API:** http://localhost:8080 (make sure Spring Boot app is running)
