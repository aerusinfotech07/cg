# FastAPI - Using MongoDB

## Motor (Async MongoDB Driver)

```python
from fastapi import FastAPI
from motor.motor_asyncio import AsyncIOMotorClient

app = FastAPI()
client = AsyncIOMotorClient("mongodb://localhost:27017")
db = client.mydb

@app.on_event("startup")
async def startup():
    app.state.db = db

@app.get("/items")
async def get_items():
    cursor = db.items.find({})
    items = await cursor.to_list(100)
    return items

@app.post("/items")
async def create_item(item: dict):
    result = await db.items.insert_one(item)
    return {"id": str(result.inserted_id)}
```

## Install

```bash
pip install motor pymongo
```

## Next Steps

- [Using GraphQL](28_using_graphql.md)
