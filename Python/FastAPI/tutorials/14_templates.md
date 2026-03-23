# FastAPI - Templates

## Jinja2 Templates

Use **Jinja2Templates** for HTML responses:

```python
from fastapi import FastAPI, Request
from fastapi.templating import Jinja2Templates

app = FastAPI()
templates = Jinja2Templates(directory="templates")

@app.get("/")
def home(request: Request):
    return templates.TemplateResponse("index.html", {"request": request})
```

## Directory Structure

```
myapp/
  main.py
  templates/
    index.html
```

## Pass Context

```python
return templates.TemplateResponse(
    "page.html",
    {"request": request, "title": "My Page", "items": [1, 2, 3]}
)
```

## Install

```bash
pip install jinja2
```

## Next Steps

- [Static Files](15_static_files.md)
