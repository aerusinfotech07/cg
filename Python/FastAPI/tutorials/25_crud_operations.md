# FastAPI - CRUD Operations

## Full CRUD Example

```python
from fastapi import FastAPI, HTTPException
from pydantic import BaseModel

app = FastAPI()
items_db: dict[int, dict] = {}

class Item(BaseModel):
    name: str
    price: float

@app.post("/items", response_model=Item)
def create_item(item: Item):
    id = len(items_db) + 1
    items_db[id] = item.model_dump()
    return item

@app.get("/items/{item_id}")
def read_item(item_id: int):
    if item_id not in items_db:
        raise HTTPException(404, "Not found")
    return items_db[item_id]

@app.put("/items/{item_id}")
def update_item(item_id: int, item: Item):
    if item_id not in items_db:
        raise HTTPException(404, "Not found")
    items_db[item_id] = item.model_dump()
    return items_db[item_id]

@app.delete("/items/{item_id}")
def delete_item(item_id: int):
    if item_id not in items_db:
        raise HTTPException(404, "Not found")
    del items_db[item_id]
    return {"ok": True}
```

## Next Steps

- [SQL Databases](26_sql_databases.md)
