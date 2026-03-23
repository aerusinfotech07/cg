# FastAPI REST Architecture
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class Item(BaseModel):
    name: str
    price: float

@app.get("/items")
def list_items():
    return {"items": []}

@app.post("/items")
def create_item(item: Item):
    return {"created": item.model_dump()}

@app.get("/items/{item_id}")
def get_item(item_id: int):
    return {"item_id": item_id}

@app.delete("/items/{item_id}")
def delete_item(item_id: int):
    return {"deleted": item_id}
