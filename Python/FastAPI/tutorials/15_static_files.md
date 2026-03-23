# FastAPI - Static Files

## Mount Static Files

```python
from fastapi import FastAPI
from fastapi.staticfiles import StaticFiles

app = FastAPI()
app.mount("/static", StaticFiles(directory="static"), name="static")
```

Files in `static/` are served at `http://127.0.0.1:8000/static/...`

## Directory Structure

```
myapp/
  main.py
  static/
    style.css
    script.js
    images/
```

## HTML Reference

```html
<link rel="stylesheet" href="/static/style.css">
<script src="/static/script.js"></script>
```

## Next Steps

- [HTML Form Templates](16_html_form_templates.md)
