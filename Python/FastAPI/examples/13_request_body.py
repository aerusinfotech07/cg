# FastAPI Request Body
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class Item(BaseModel):
    name: str
    price: float

@app.post("/items")
def create_item(item: Item):
    return {"name": item.name, "price": item.price}

@app.put("/items/{item_id}")
def update_item(item_id: int, item: Item):
    return {"item_id": item_id, "item": item.model_dump()}
