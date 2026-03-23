"""
Python REST API for RestAPI-Axios tutorial.
Run from RestAPI-Axios/examples: uvicorn api_main:app --reload --port 8000
"""
from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from pydantic import BaseModel

app = FastAPI(title="Items API (Axios Demo)", version="1.0.0")

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

items_db: dict[int, dict] = {}


class Item(BaseModel):
    name: str
    price: float


@app.get("/")
def root():
    return {"message": "Python REST API - use /items with Axios"}


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
    items_db[item_id] = {"id": item_id, "name": item.name, "price": item.price}
    return items_db[item_id]


@app.put("/items/{item_id}")
def update_item(item_id: int, item: Item):
    if item_id not in items_db:
        raise HTTPException(404, "Item not found")
    items_db[item_id] = {"id": item_id, "name": item.name, "price": item.price}
    return items_db[item_id]


@app.delete("/items/{item_id}")
def delete_item(item_id: int):
    if item_id not in items_db:
        raise HTTPException(404, "Item not found")
    del items_db[item_id]
    return {"ok": True}
