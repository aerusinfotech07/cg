# FastAPI - OpenAPI

## Automatic OpenAPI Schema

FastAPI generates an **OpenAPI** schema from your app. No extra code needed.

## Endpoints

- **Swagger UI** – `http://127.0.0.1:8000/docs`
- **ReDoc** – `http://127.0.0.1:8000/redoc`
- **OpenAPI JSON** – `http://127.0.0.1:8000/openapi.json`

## Customize Schema

```python
from fastapi import FastAPI

app = FastAPI(
    title="My API",
    description="API description",
    version="1.0.0",
    openapi_url="/api/v1/openapi.json"
)
```

## Next Steps

- [Uvicorn](05_uvicorn.md)
