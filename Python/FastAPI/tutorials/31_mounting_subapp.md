# FastAPI - Mounting A Sub-App

## Sub-Application

```python
from fastapi import FastAPI

sub_app = FastAPI()

@sub_app.get("/")
def sub_root():
    return {"message": "From sub-app"}

@sub_app.get("/items")
def sub_items():
    return {"items": []}
```

## Mount on Main App

```python
app = FastAPI()

app.mount("/api/v1", sub_app)
```

Sub-app routes are at `/api/v1/`, `/api/v1/items`, etc.

## Next Steps

- [Middleware](32_middleware.md)
