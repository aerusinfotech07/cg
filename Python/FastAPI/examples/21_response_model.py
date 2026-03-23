# FastAPI Response Model
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class UserOut(BaseModel):
    name: str
    email: str

@app.get("/user", response_model=UserOut)
def get_user():
    return {"name": "Alice", "email": "alice@example.com"}
