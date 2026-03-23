# FastAPI Static Files - mount static directory
from pathlib import Path
from fastapi import FastAPI
from fastapi.staticfiles import StaticFiles

app = FastAPI()
examples_dir = Path(__file__).parent
static_dir = examples_dir / "static"
if static_dir.exists():
    app.mount("/static", StaticFiles(directory=str(static_dir)), name="static")

@app.get("/")
def root():
    return {"message": "Static files at /static/ if 'static' folder exists"}
