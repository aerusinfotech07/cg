# REST API Endpoints (CRUD)

## Resource: Items

| Method | URL | Description |
|--------|-----|-------------|
| GET | /items | List all items |
| GET | /items/{id} | Get one item |
| POST | /items | Create item |
| PUT | /items/{id} | Update item |
| DELETE | /items/{id} | Delete item |

## Example with FastAPI

```python
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel

app = FastAPI()
items_db: dict[int, dict] = {}

class Item(BaseModel):
    name: str
    price: float

@app.get("/items")
def list_items():
    return {"items": list(items_db.values())}

@app.get("/items/{item_id}")
def get_item(item_id: int):
    if item_id not in items_db:
        raise HTTPException(404, "Item not found")
    return items_db[item_id]

@app.post("/items")
def create_item(item: Item):
    item_id = len(items_db) + 1
    items_db[item_id] = {"id": item_id, **item.model_dump()}
    return items_db[item_id]

@app.put("/items/{item_id}")
def update_item(item_id: int, item: Item):
    if item_id not in items_db:
        raise HTTPException(404, "Item not found")
    items_db[item_id] = {"id": item_id, **item.model_dump()}
    return items_db[item_id]

@app.delete("/items/{item_id}")
def delete_item(item_id: int):
    if item_id not in items_db:
        raise HTTPException(404, "Item not found")
    del items_db[item_id]
    return {"ok": True}
```

## Next Steps

- [CORS for Frontend](04_cors_for_frontend.md)
