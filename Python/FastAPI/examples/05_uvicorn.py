# FastAPI + Uvicorn - run programmatically
from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def root():
    return {"message": "Run with: uvicorn FastAPI.examples.05_uvicorn:app"}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)
