# FastAPI - Parameter Validation

## Validation with Annotated

Use `Query`, `Path`, etc. for validation and metadata:

```python
from fastapi import FastAPI, Query, Path

app = FastAPI()

@app.get("/items")
def items(
    q: str | None = Query(None, min_length=3, max_length=50),
    skip: int = Query(0, ge=0),
    limit: int = Query(10, ge=1, le=100)
):
    return {"q": q, "skip": skip, "limit": limit}
```

## Path Validation

```python
@app.get("/items/{item_id}")
def get_item(
    item_id: int = Path(..., ge=1, title="Item ID")
):
    return {"item_id": item_id}
```

## Regex and Description

```python
q: str | None = Query(None, regex="^[a-z]+$", description="Search query")
```

## Next Steps

- [Pydantic](12_pydantic.md)
