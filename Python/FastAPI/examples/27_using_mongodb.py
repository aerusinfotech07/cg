# FastAPI Using MongoDB - requires motor: pip install motor
from fastapi import FastAPI

app = FastAPI()

# In real app: client = AsyncIOMotorClient("mongodb://localhost:27017"); db = client.mydb

@app.get("/items")
async def get_items():
    return {"items": [], "note": "Connect Motor client for real MongoDB"}

@app.post("/items")
async def create_item(item: dict):
    return {"id": "demo", "item": item}
