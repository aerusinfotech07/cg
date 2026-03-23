# FastAPI HTML Form Templates - show form and handle submit
from pathlib import Path
from fastapi import FastAPI, Request, Form
from fastapi.templating import Jinja2Templates

app = FastAPI()
examples_dir = Path(__file__).parent
templates_dir = examples_dir / "templates"
templates = Jinja2Templates(directory=str(templates_dir)) if templates_dir.exists() else None

@app.get("/form")
def form_page(request: Request):
    if templates:
        return templates.TemplateResponse("form.html", {"request": request})
    return {"message": "Add templates/form.html for form demo"}

@app.post("/submit")
def submit(name: str = Form(...), email: str | None = Form(None)):
    return {"name": name, "email": email}
