# FastAPI Mounting Sub-App
from fastapi import FastAPI

sub_app = FastAPI()

@sub_app.get("/")
def sub_root():
    return {"message": "From sub-app"}

@sub_app.get("/items")
def sub_items():
    return {"items": []}

app = FastAPI()
app.mount("/api/v1", sub_app)

@app.get("/")
def root():
    return {"message": "Main app. Sub-app at /api/v1/"}
