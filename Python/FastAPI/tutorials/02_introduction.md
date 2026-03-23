# FastAPI - Introduction

## What is FastAPI?

FastAPI is a web framework for building REST and other APIs. It uses:

- **Starlette** for web handling
- **Pydantic** for data validation
- **OpenAPI** for automatic API documentation

## Why FastAPI?

| Feature | Benefit |
|---------|---------|
| Type hints | Validation, autocomplete, fewer bugs |
| Async support | High concurrency with async/await |
| Auto docs | Swagger UI at `/docs`, ReDoc at `/redoc` |
| Performance | One of the fastest Python frameworks |

## Minimal App

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def read_root():
    return {"message": "Hello from FastAPI"}
```

## Next Steps

- [Hello World](03_hello_world.md)
