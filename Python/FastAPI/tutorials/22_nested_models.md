# FastAPI - Nested Models

## Nested Pydantic Model

```python
from pydantic import BaseModel

class Image(BaseModel):
    url: str
    name: str

class Item(BaseModel):
    name: str
    image: Image | None = None
    tags: list[str] = []

@app.post("/items")
def create_item(item: Item):
    return item
```

## List of Nested

```python
class Item(BaseModel):
    name: str
    images: list[Image] = []
```

## Deep Nesting

```python
class Address(BaseModel):
    city: str
    country: str

class User(BaseModel):
    name: str
    address: Address
```

## Next Steps

- [Dependencies](23_dependencies.md)
