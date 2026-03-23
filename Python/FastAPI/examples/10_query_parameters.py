# FastAPI Query Parameters
from fastapi import FastAPI

app = FastAPI()

@app.get("/items")
def list_items(skip: int = 0, limit: int = 10):
    return {"skip": skip, "limit": limit}

@app.get("/search")
def search(q: str | None = None):
    return {"q": q}
