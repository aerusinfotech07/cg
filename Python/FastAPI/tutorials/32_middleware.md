# FastAPI - Middleware

## Add Middleware

```python
from fastapi import FastAPI

app = FastAPI()

@app.middleware("http")
async def add_process_time_header(request, call_next):
    response = await call_next(request)
    response.headers["X-Custom"] = "value"
    return response
```

## Order

Middleware runs in order: first added = outermost (runs first on request, last on response).

## CORS Middleware

```python
from fastapi.middleware.cors import CORSMiddleware
app.add_middleware(CORSMiddleware, allow_origins=["*"])
```

## Next Steps

- [Mounting Flask App](33_mounting_flask.md)
