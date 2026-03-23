# Asynchronous Web Applications — Concept Notes

This document explains the concepts used in this servlet + JSP application: **asynchronous servlets**, **sending HTTP from JavaScript**, **handling the response in JavaScript**, and **combining them for a server-push effect**. The project uses **no Maven**; it is a standard Dynamic Web Project (e.g. Eclipse) deployable to Tomcat 9+.

---

## 1. Using the Asynchronous Servlet Mechanism

### What is it?

In a normal servlet, the thread that handles the request stays busy until the response is fully written. If the server has to wait (e.g. for a message, an external API, or a database), that thread is **blocked** and cannot serve other requests.

The **asynchronous servlet** mechanism (Servlet 3.0+) allows the container to **release the request thread** while the logical “request” is still open. The response is completed later, possibly from another thread.

### How it works (Servlet 3.1)

1. Inside `doGet` or `doPost`, call **`request.startAsync()`**. You get an **`AsyncContext`**.
2. The **request thread returns** to the container (it is no longer blocked).
3. You store the `AsyncContext` somewhere (e.g. a list of “waiting clients”).
4. When data is ready (message arrived, timeout, etc.), you use the stored context to write the response and call **`asyncContext.complete()`**.

### Key APIs

| API | Purpose |
|-----|--------|
| `HttpServletRequest.startAsync()` | Start async processing; returns `AsyncContext`. |
| `AsyncContext.setTimeout(long ms)` | Max time to wait; after that `AsyncListener.onTimeout` is called. |
| `AsyncContext.addListener(AsyncListener)` | React to complete, timeout, error. |
| `AsyncContext.getRequest()` / `getResponse()` | Access request/response to write the reply. |
| `AsyncContext.complete()` | Finish the async request (must be called once). |

### In this project

- **`AsyncLongPollServlet`** (mapped to `/updates`) calls `request.startAsync()`, sets a timeout, and registers the `AsyncContext` with **`AsyncBroadcaster`**.
- **`AsyncBroadcaster`** holds all waiting contexts. On timeout, it sends `{"type":"timeout"}` and completes. When a message is broadcast, it sends JSON to each waiting client and completes.

**Use cases:** Long polling, event streaming, chat, notifications, waiting for external services without tying up one thread per client.

---

## 2. Using JavaScript to Send an HTTP Request from a Client

### What is it?

The browser can send HTTP requests **without reloading the page**, using JavaScript. This is the basis of **AJAX** (Asynchronous JavaScript and XML). Here we use the **Fetch API** (modern); the same idea applies with **XMLHttpRequest**.

### How it works

- **GET:** Request data (e.g. “any new updates?”).  
  `fetch('updates', { cache: 'no-store' })`
- **POST:** Send data (e.g. a message).  
  `fetch('send', { method: 'POST', headers: {...}, body: 'text=' + encodeURIComponent(...) })`

The request is sent in the background; the page stays responsive.

### In this project

- **Long poll (GET):** `app.js` calls `fetch('updates', { cache: 'no-store' })` to wait for server events.
- **Send message (POST):** When the user clicks Send, `app.js` calls `fetch('send', { method: 'POST', headers: { 'Content-Type': 'application/x-www-form-urlencoded' }, body: 'text=' + encodeURIComponent(text) })`.

So: **the client uses JavaScript to send HTTP requests** to the servlets.

---

## 3. Processing an HTTP Response Entirely in JavaScript

### What is it?

With `fetch()` (or XHR), the **response** is not used to replace the whole page. Instead, the **response body is available in JavaScript** (e.g. as text or JSON). Your script can then update the DOM, show messages, or trigger more requests.

### How it works

```javascript
fetch('updates')
  .then(function (res) { return res.json(); })
  .then(function (data) {
    // data is the parsed JSON
    if (data.type === 'message') {
      console.log(data.text);
    }
  });
```

So: **the entire handling of the HTTP response** (parsing, logic, UI update) happens **in JavaScript**, with no full page reload.

### In this project

- **`/updates`** returns JSON: either `{"type":"message","text":"...","ts":"..."}` or `{"type":"timeout"}`.  
  `app.js` uses `.then(res => res.json())` and then updates the log area and status.
- **`/send`** returns `{"status":"ok"}`. The client may clear the input or handle errors in JS.

So: **all response processing is in JavaScript**.

---

## 4. Combining These Techniques to Create the Effect of Server-Push

### The problem

HTTP is **request–response**: the server cannot initiate a connection to the browser. So the server cannot “push” data on its own.

### The solution: long polling (simulated server-push)

1. **Client** sends a request to `/updates` (using JavaScript — concept 2).
2. **Server** keeps the request **open** using an **asynchronous servlet** (concept 1): the thread is released, but the response is not sent yet.
3. When a **message arrives** (or a timeout occurs), the server **sends the response** (JSON) and closes that request.
4. **Client** receives the response **entirely in JavaScript** (concept 3), updates the UI, then **immediately sends another request** to `/updates`.
5. Repeat from step 2.

From the user’s point of view, **new messages appear as if the server pushed them**, even though every time it was the client that initiated the HTTP request.

### In this project

- **Async servlet** keeps many clients waiting without blocking many threads.
- **JavaScript** sends GET to `/updates` and POST to `/send`, and processes all responses in JS.
- **Combined:** continuous long polling + send message = **server-push effect**.

---

## Project structure (no Maven)

```
async-webapp-dynamic/
  src/com/example/async/
    AsyncLongPollServlet.java   → GET /updates (async, long poll)
    AsyncBroadcaster.java       → holds waiting clients, broadcasts messages
    MessageServlet.java         → POST /send (receives message, broadcasts)
  WebContent/
    index.jsp                   → UI + includes app.js
    js/app.js                   → fetch to /updates and /send, handles JSON
    WEB-INF/
      web.xml                   → Servlet 3.1, welcome file
```

## How to run (e.g. Eclipse + Tomcat 9)

1. **File → New → Dynamic Web Project.**  
   Name: `async-webapp-dynamic`.  
   Target runtime: **Tomcat 9**.  
   Dynamic web module: **3.1**.
2. Copy `src` and `WebContent` into the project.
3. **Project → Properties → Java Build Path → Add Library → Server Runtime → Tomcat 9.**
4. **Run on Server.**  
   Open: `http://localhost:8080/async-webapp-dynamic/`
5. Open the same URL in another tab; type a message in one tab and click Send — it should appear in the other tab (server-push effect).

---

## Summary

| Concept | What it means in this app |
|--------|----------------------------|
| **Asynchronous servlet** | `/updates` uses `startAsync()`, stores `AsyncContext`, and completes when a message arrives or on timeout. |
| **JavaScript sends HTTP** | `fetch('updates')` and `fetch('send', { method: 'POST', ... })` send GET and POST from the browser. |
| **Response in JavaScript** | All responses are handled with `.then(res => res.json())` and DOM updates in `app.js`. |
| **Server-push effect** | Long polling (repeated GET to `/updates`) + broadcast on POST to `/send` makes new messages appear as if pushed by the server. |
