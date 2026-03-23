# FastAPI Cookie Parameters
from fastapi import FastAPI, Cookie, Response

app = FastAPI()

@app.get("/")
def read_cookie(session_id: str | None = Cookie(None)):
    return {"session_id": session_id}

@app.get("/set-cookie")
def set_cookie(response: Response):
    response.set_cookie(key="session_id", value="demo-123")
    return {"message": "Cookie set"}
