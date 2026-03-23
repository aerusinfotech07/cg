# FastAPI - Type Hints

## Why Type Hints?

FastAPI uses Python type hints to:

- **Validate** request data
- **Serialize** response data
- **Generate** OpenAPI schema
- **Improve** IDE support

## Examples

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/items/{item_id}")
def get_item(item_id: int):  # int → validation
    return {"item_id": item_id}

@app.get("/search")
def search(q: str | None = None, limit: int = 10):
    return {"q": q, "limit": limit}
```

## Common Types

- `str`, `int`, `float`, `bool`
- `list[str]`, `dict[str, int]`
- `Optional[str]` or `str | None`
- Pydantic models

## Next Steps

- [IDE Support](07_ide_support.md)
