# Node.js HTTP Module Notes

## Overview
- Built-in `http` module lets you create servers and make HTTP requests.
- Core to building web apps and APIs without external frameworks.

## Importing the Module
```js
// CommonJS (default)
const http = require('http');

// ES Modules (package.json with "type": "module")
import http from 'http';
```

## Creating a Basic HTTP Server
```js
const http = require('http');

const server = http.createServer((req, res) => {
  res.writeHead(200, { 'Content-Type': 'text/plain' });
  res.end('Hello, World!\n');
});

const PORT = 3000;
server.listen(PORT, 'localhost', () => {
  console.log(`Server running at http://localhost:${PORT}/`);
});
```

### Core Concepts
- `http.createServer()` creates a server instance.
- Callback receives:
  - `req` (`http.IncomingMessage`)
  - `res` (`http.ServerResponse`)
- `res.writeHead(status, headers)` sets status + headers.
- `res.end()` sends response and closes connection.

## Working with Headers
```js
res.writeHead(200, {
  'Content-Type': 'text/html',
  'X-Powered-By': 'Node.js',
  'Cache-Control': 'no-cache, no-store, must-revalidate',
  'Set-Cookie': 'sessionid=abc123; HttpOnly'
});
```

### Common Response Headers
- `Content-Type`
- `Content-Length`
- `Location`
- `Set-Cookie`
- `Cache-Control`
- `Access-Control-Allow-Origin` (CORS)

### Reading Request Headers
```js
const userAgent = req.headers['user-agent'];
const acceptLang = req.headers['accept-language'];
```

## Common Status Codes
- `200 OK`
- `201 Created`
- `204 No Content`
- `301 Moved Permanently`
- `400 Bad Request`
- `401 Unauthorized`
- `403 Forbidden`
- `404 Not Found`
- `500 Internal Server Error`

## URLs and Query Strings

### Accessing URL
```js
const { url, method } = req;
```

### Parsing with `url` module
```js
const url = require('url');
const parsed = url.parse(req.url, true);
const pathname = parsed.pathname;
const query = parsed.query;
```

### Recommended (WHATWG URL API)
```js
const { URL } = require('url');
const parsedUrl = new URL(req.url, `http://${req.headers.host}`);
const params = Object.fromEntries(parsedUrl.searchParams);
```

### `querystring` module
```js
const querystring = require('querystring');
const qs = querystring.stringify({ a: 1, b: 2 });
```

## Handling HTTP Methods (Basic REST)
- `GET` — read (idempotent)
- `POST` — create (not idempotent)
- `PUT` — replace (idempotent)
- `PATCH` — partial update
- `DELETE` — remove (idempotent)
- `HEAD` — headers only
- `OPTIONS` — allowed methods

### Method Routing Pattern
```js
if (method === 'GET' && pathname === '/todos') {
  // ...
} else if (method === 'POST' && pathname === '/todos') {
  // ...
}
```

## Request Body Parsing (Manual)
```js
let body = '';
req.on('data', chunk => body += chunk.toString());
req.on('end', () => {
  const data = JSON.parse(body);
  // ...
});
```

## Error Handling Best Practices
Use correct status codes and consistent error payloads:
- `400` for invalid JSON/input
- `404` for missing resource
- `500` for server errors

## Streaming Responses
Streams handle large payloads efficiently.

### Example: Stream File
```js
const fs = require('fs');
const stream = fs.createReadStream(filePath);
stream.pipe(res);
```

### Why Streaming
- Lower memory usage
- Faster time-to-first-byte
- Backpressure handled automatically

## Runnable Example (Single File)
Save as `http-server.js` and run: `node http-server.js`
```js
const http = require('http');
const { URL } = require('url');

let todos = [
  { id: 1, task: 'Learn Node.js', completed: false },
  { id: 2, task: 'Build an API', completed: false }
];

const server = http.createServer((req, res) => {
  const { method, url } = req;
  const parsedUrl = new URL(url, `http://${req.headers.host}`);
  const pathname = parsedUrl.pathname;

  res.setHeader('Access-Control-Allow-Origin', '*');
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
  res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

  if (method === 'OPTIONS') {
    res.writeHead(204);
    res.end();
    return;
  }

  if (method === 'GET' && pathname === '/todos') {
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify(todos));
    return;
  }

  if (method === 'POST' && pathname === '/todos') {
    let body = '';
    req.on('data', chunk => body += chunk.toString());
    req.on('end', () => {
      try {
        const newTodo = JSON.parse(body);
        newTodo.id = todos.length > 0 ? Math.max(...todos.map(t => t.id)) + 1 : 1;
        todos.push(newTodo);
        res.writeHead(201, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify(newTodo));
      } catch (err) {
        res.writeHead(400, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ error: 'Invalid JSON' }));
      }
    });
    return;
  }

  if (method === 'PUT' && pathname.startsWith('/todos/')) {
    const id = parseInt(pathname.split('/')[2], 10);
    let body = '';
    req.on('data', chunk => body += chunk.toString());
    req.on('end', () => {
      try {
        const updatedTodo = JSON.parse(body);
        const index = todos.findIndex(t => t.id === id);
        if (index === -1) {
          res.writeHead(404, { 'Content-Type': 'application/json' });
          res.end(JSON.stringify({ error: 'Todo not found' }));
          return;
        }
        todos[index] = { ...todos[index], ...updatedTodo };
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify(todos[index]));
      } catch (err) {
        res.writeHead(400, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ error: 'Invalid JSON' }));
      }
    });
    return;
  }

  if (method === 'DELETE' && pathname.startsWith('/todos/')) {
    const id = parseInt(pathname.split('/')[2], 10);
    const index = todos.findIndex(t => t.id === id);
    if (index === -1) {
      res.writeHead(404, { 'Content-Type': 'application/json' });
      res.end(JSON.stringify({ error: 'Todo not found' }));
      return;
    }
    todos = todos.filter(t => t.id !== id);
    res.writeHead(204);
    res.end();
    return;
  }

  res.writeHead(404, { 'Content-Type': 'application/json' });
  res.end(JSON.stringify({ error: 'Not Found' }));
});

const PORT = 3000;
server.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}/`);
});
```
