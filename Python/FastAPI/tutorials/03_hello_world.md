# FastAPI - Hello World

## Basic Hello World

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def root():
    return {"message": "Hello World"}

@app.get("/hello/{name}")
def hello(name: str):
    return {"message": f"Hello, {name}"}
```

## Run with Uvicorn

```bash
uvicorn main:app --reload
```

Then open: `http://127.0.0.1:8000` and `http://127.0.0.1:8000/docs`

## Next Steps

- [OpenAPI](04_openapi.md)
