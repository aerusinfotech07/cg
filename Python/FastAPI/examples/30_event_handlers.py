# FastAPI Event Handlers
from fastapi import FastAPI

app = FastAPI()

@app.on_event("startup")
async def startup_event():
    print("Application starting...")

@app.on_event("shutdown")
async def shutdown_event():
    print("Application shutting down...")

@app.get("/")
def root():
    return {"message": "Check console for startup/shutdown logs"}
