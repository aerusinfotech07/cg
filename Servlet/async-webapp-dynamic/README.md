# Async Web Application (Servlet + JSP, no Maven)

Small demo of **asynchronous web applications**: async servlets, JavaScript HTTP (fetch), response handling in JS, and **server-push effect** via long polling.

## Quick start

- **Eclipse:** New Dynamic Web Project → copy `src` and `WebContent` → Add Tomcat 9 runtime → Run on Server.
- **URL:** `http://localhost:8080/async-webapp-dynamic/`
- Open two browser tabs; send a message in one — it appears in the other (server-push).

## Concepts covered

1. **Asynchronous Servlet** — `AsyncLongPollServlet` uses `startAsync()` and `AsyncBroadcaster`.
2. **JavaScript sends HTTP** — `fetch()` for GET `/updates` and POST `/send`.
3. **Response in JavaScript** — JSON parsed and DOM updated in `app.js`.
4. **Server-push effect** — Long polling + broadcast = messages “pushed” to all clients.

See **NOTES.md** for detailed concept explanations.
