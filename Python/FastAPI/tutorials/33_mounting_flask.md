# FastAPI - Mounting Flask App

## WSGIMiddleware

Run a Flask app under FastAPI using **WSGIMiddleware**:

```python
from fastapi import FastAPI
from fastapi.middleware.wsgi import WSGIMiddleware
from flask import Flask

flask_app = Flask(__name__)

@flask_app.route("/flask")
def flask_hello():
    return "Hello from Flask"

app = FastAPI()
app.mount("/flask", WSGIMiddleware(flask_app))
```

Flask routes are available under `/flask/...`.

## Install

```bash
pip install flask
```

## Next Steps

- [Deployment](34_deployment.md)
