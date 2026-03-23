# FastAPI Pydantic
from fastapi import FastAPI
from pydantic import BaseModel, Field

class Item(BaseModel):
    name: str = Field(..., min_length=1)
    price: float = Field(gt=0)
    is_offer: bool | None = None

app = FastAPI()

@app.post("/items")
def create_item(item: Item):
    return item
