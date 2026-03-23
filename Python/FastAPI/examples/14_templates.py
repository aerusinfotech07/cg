# FastAPI Templates - requires templates/ folder with index.html
from pathlib import Path
from fastapi import FastAPI, Request
from fastapi.templating import Jinja2Templates

app = FastAPI()
examples_dir = Path(__file__).parent
templates_dir = examples_dir / "templates"
if templates_dir.exists():
    templates = Jinja2Templates(directory=str(templates_dir))
else:
    templates = None

@app.get("/")
def home(request: Request):
    if templates:
        return templates.TemplateResponse("index.html", {"request": request, "title": "FastAPI"})
    return {"message": "Create a 'templates' folder with index.html for template demo"}
