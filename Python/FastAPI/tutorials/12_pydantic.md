# FastAPI - Pydantic

## Pydantic Models

FastAPI uses **Pydantic** for request/response validation and serialization.

```python
from pydantic import BaseModel

class Item(BaseModel):
    name: str
    price: float
    is_offer: bool | None = None
```

## Use in Endpoints

```python
@app.post("/items")
def create_item(item: Item):
    return item
```

FastAPI will validate JSON body against `Item` and return 422 if invalid.

## Field Validation

```python
from pydantic import BaseModel, Field

class Item(BaseModel):
    name: str = Field(..., min_length=1)
    price: float = Field(gt=0)
```

## Next Steps

- [Request Body](13_request_body.md)
