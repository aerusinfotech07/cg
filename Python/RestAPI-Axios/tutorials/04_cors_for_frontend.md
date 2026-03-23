# CORS for Frontend

## Why CORS?

When the frontend (e.g. `http://localhost:3000`) calls the API (`http://localhost:8000`), the browser enforces **CORS**. The API must allow the frontend origin.

## Enable CORS in FastAPI

```python
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["http://localhost:3000", "http://127.0.0.1:3000"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)
```

## Development: Allow All Origins

```python
allow_origins=["*"]
```

Use `*` only for local development; in production specify your frontend URL(s).

## Next Steps

- [Introduction to Axios](05_introduction_to_axios.md)
