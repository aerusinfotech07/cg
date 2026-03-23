# FastAPI Parameter Validation
from fastapi import FastAPI, Query, Path

app = FastAPI()

@app.get("/items")
def items(
    q: str | None = Query(None, min_length=1, max_length=50),
    skip: int = Query(0, ge=0),
    limit: int = Query(10, ge=1, le=100),
):
    return {"q": q, "skip": skip, "limit": limit}

@app.get("/items/{item_id}")
def get_item(item_id: int = Path(..., ge=1)):
    return {"item_id": item_id}
