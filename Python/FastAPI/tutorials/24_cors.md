# FastAPI - CORS

## Enable CORS

```python
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # or ["https://myfrontend.com"]
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.get("/")
def root():
    return {"message": "Hello"}
```

## Restrict Origins

```python
allow_origins=["https://example.com", "https://app.example.com"]
```

## Next Steps

- [CRUD Operations](25_crud_operations.md)
