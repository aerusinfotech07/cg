# Python REST API Setup

## Create a FastAPI App

```python
from fastapi import FastAPI

app = FastAPI(title="Items API", version="1.0.0")

@app.get("/")
def root():
    return {"message": "REST API is running"}
```

## Run with Uvicorn

```bash
pip install fastapi uvicorn
uvicorn main:app --reload --port 8000
```

API base URL: `http://127.0.0.1:8000`

## Return JSON

FastAPI automatically serializes dicts and Pydantic models to JSON:

```python
@app.get("/health")
def health():
    return {"status": "ok"}
```

## OpenAPI Docs

- Swagger UI: `http://127.0.0.1:8000/docs`
- ReDoc: `http://127.0.0.1:8000/redoc`

## Next Steps

- [REST API Endpoints (CRUD)](03_rest_api_endpoints.md)
