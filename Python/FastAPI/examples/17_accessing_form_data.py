# FastAPI Accessing Form Data - requires python-multipart
from fastapi import FastAPI, Form

app = FastAPI()

@app.post("/login")
def login(username: str = Form(...), password: str = Form(...)):
    return {"username": username}

@app.post("/submit")
def submit(name: str = Form(...), email: str | None = Form(None)):
    return {"name": name, "email": email}
