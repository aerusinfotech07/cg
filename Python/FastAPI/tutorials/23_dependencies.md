# FastAPI - Dependencies

## Depends()

```python
from fastapi import FastAPI, Depends

app = FastAPI()

def common_parameters(q: str | None = None, skip: int = 0, limit: int = 10):
    return {"q": q, "skip": skip, "limit": limit}

@app.get("/items")
def items(commons: dict = Depends(common_parameters)):
    return commons
```

## Class as Dependency

```python
class CommonQuery:
    def __init__(self, q: str | None = None, limit: int = 10):
        self.q = q
        self.limit = limit

@app.get("/items")
def items(commons: CommonQuery = Depends()):
    return {"q": commons.q, "limit": commons.limit}
```

## Sub-dependencies

```python
def get_db():
    return "db"

def get_user(db: str = Depends(get_db)):
    return "user from " + db

@app.get("/user")
def read_user(user: str = Depends(get_user)):
    return user
```

## Next Steps

- [CORS](24_cors.md)
