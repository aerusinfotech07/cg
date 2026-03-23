# FastAPI Nested Models
from fastapi import FastAPI
from pydantic import BaseModel

class Image(BaseModel):
    url: str
    name: str

class Item(BaseModel):
    name: str
    image: Image | None = None
    tags: list[str] = []

app = FastAPI()

@app.post("/items")
def create_item(item: Item):
    return item
