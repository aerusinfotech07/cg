# FastAPI - Accessing Form Data

## Form Parameters

Use `Form()` for form fields (not JSON):

```python
from fastapi import FastAPI, Form

app = FastAPI()

@app.post("/login")
def login(username: str = Form(...), password: str = Form(...)):
    return {"username": username}
```

## Optional Form Fields

```python
@app.post("/submit")
def submit(
    name: str = Form(...),
    email: str | None = Form(None)
):
    return {"name": name, "email": email}
```

## Install

Form support is built-in. Ensure you have `python-multipart`:

```bash
pip install python-multipart
```

## Next Steps

- [Uploading Files](18_uploading_files.md)
