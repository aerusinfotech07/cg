# FastAPI Path Parameters
from enum import Enum
from fastapi import FastAPI

app = FastAPI()

class ModelName(str, Enum):
    a = "a"
    b = "b"

@app.get("/items/{item_id}")
def get_item(item_id: int):
    return {"item_id": item_id}

@app.get("/models/{model_name}")
def get_model(model_name: ModelName):
    return {"model": model_name}
