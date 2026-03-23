# Full Example: Python API + Axios Frontend

## Backend (Python FastAPI)

- Run: `uvicorn RestAPI-Axios.examples.api_main:app --reload --port 8000`
- Endpoints: GET/POST /items, GET/PUT/DELETE /items/{id}
- CORS enabled for frontend

## Frontend (HTML + Axios)

- Open `examples/frontend/index.html` in a browser (or serve it via a local server).
- Uses Axios CDN; buttons call the Python API for list, create, update, delete.

## Flow

1. Start the Python API on port 8000.
2. Open the HTML file (or serve it on e.g. port 3000).
3. Use the UI to perform CRUD operations; Axios sends requests to the API.

## Project Layout

```
RestAPI-Axios/
  examples/
    api_main.py           # FastAPI app
    frontend/
      index.html          # Page with Axios calls
```

## Return to Index

- [TUTORIAL_INDEX](../TUTORIAL_INDEX.md)
