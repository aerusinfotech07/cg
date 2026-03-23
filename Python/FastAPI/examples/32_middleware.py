# FastAPI Middleware
from fastapi import FastAPI

app = FastAPI()

@app.middleware("http")
async def add_custom_header(request, call_next):
    response = await call_next(request)
    response.headers["X-Custom-Header"] = "Demo"
    return response

@app.get("/")
def root():
    return {"message": "Check response headers for X-Custom-Header"}
