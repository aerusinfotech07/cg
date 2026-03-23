# FastAPI Type Hints
from fastapi import FastAPI

app = FastAPI()

@app.get("/items/{item_id}")
def get_item(item_id: int):
    return {"item_id": item_id}

@app.get("/search")
def search(q: str | None = None, limit: int = 10):
    return {"q": q, "limit": limit}
