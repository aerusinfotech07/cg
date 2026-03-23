# FastAPI - Request Body

## Single Body

```python
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class Item(BaseModel):
    name: str
    price: float

@app.post("/items")
def create_item(item: Item):
    return {"name": item.name, "price": item.price}
```

## Body + Path + Query

```python
@app.put("/items/{item_id}")
def update_item(item_id: int, item: Item, q: str | None = None):
    return {"item_id": item_id, "item": item, "q": q}
```

## Multiple Body Parameters

```python
class User(BaseModel):
    name: str

@app.post("/multi")
def multi(user: User, item: Item):
    return {"user": user, "item": item}
```

## Embed Body

```python
@app.post("/embed")
def embed(item: Item = Body(..., embed=True)):
    return item
# Expects: {"item": {"name": "...", "price": 1.0}}
```

## Next Steps

- [Templates](14_templates.md)
