# Introduction: Python REST API + Axios

## What This Tutorial Covers

1. **Python REST API** – Building a RESTful API with **FastAPI** (Python).
2. **Axios** – Using **Axios** (JavaScript) to call that API from a web frontend or Node.js.

## Roles

| Component | Technology | Role |
|-----------|------------|------|
| Backend | Python (FastAPI) | Exposes REST endpoints (JSON); runs on a server (e.g. port 8000). |
| Frontend / Client | JavaScript (Axios) | Sends HTTP requests (GET, POST, PUT, DELETE) to the API. |

## Why Axios?

- **Axios** is a promise-based HTTP client for JavaScript (browser or Node.js).
- Simple API: `axios.get()`, `axios.post()`, etc.
- Handles JSON by default, interceptors, and request/response transformation.

## Typical Flow

```
Browser (HTML + JS + Axios)  →  HTTP request  →  Python FastAPI server
Browser (HTML + JS + Axios)  ←  JSON response ←  Python FastAPI server
```

## Next Steps

- [Python REST API Setup](02_python_rest_api_setup.md)
