# FastAPI - Query Parameters

## Basic Query Parameters

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/items")
def list_items(skip: int = 0, limit: int = 10):
    return {"skip": skip, "limit": limit}
```

URL: `/items?skip=0&limit=20`

## Optional Parameters

```python
@app.get("/search")
def search(q: str | None = None):
    return {"q": q}
```

## Boolean Query

```python
@app.get("/items")
def items(active: bool = True):
    return {"active": active}
```

## Multiple Values (list)

```python
@app.get("/items")
def items(tags: list[str] = []):
    return {"tags": tags}
# /items?tags=foo&tags=bar
```

## Next Steps

- [Parameter Validation](11_parameter_validation.md)
