# FastAPI Dependencies
from fastapi import FastAPI, Depends

app = FastAPI()

def common_parameters(q: str | None = None, skip: int = 0, limit: int = 10):
    return {"q": q, "skip": skip, "limit": limit}

@app.get("/items")
def items(commons: dict = Depends(common_parameters)):
    return commons

class CommonQuery:
    def __init__(self, q: str | None = None, limit: int = 10):
        self.q = q
        self.limit = limit

@app.get("/search")
def search(commons: CommonQuery = Depends()):
    return {"q": commons.q, "limit": commons.limit}
