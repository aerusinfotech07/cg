# FastAPI Header Parameters
from fastapi import FastAPI, Header

app = FastAPI()

@app.get("/")
def read_headers(
    user_agent: str | None = Header(None),
    x_custom: str | None = Header(None),
):
    return {"User-Agent": user_agent, "X-Custom": x_custom}
