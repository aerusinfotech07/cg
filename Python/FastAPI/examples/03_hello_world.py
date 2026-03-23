# FastAPI Hello World
from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def root():
    return {"message": "Hello World"}

@app.get("/hello/{name}")
def hello(name: str):
    return {"message": f"Hello, {name}"}

# Run: uvicorn FastAPI.examples.03_hello_world:app --reload
