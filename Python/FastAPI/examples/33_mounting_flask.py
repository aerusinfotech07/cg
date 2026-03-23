# FastAPI Mounting Flask App - requires: pip install flask
from fastapi import FastAPI

app = FastAPI()

try:
    from starlette.middleware.wsgi import WSGIMiddleware
    from flask import Flask
    flask_app = Flask(__name__)

    @flask_app.route("/flask")
    def flask_hello():
        return "Hello from Flask"

    app.mount("/flask", WSGIMiddleware(flask_app))
except Exception as e:
    pass  # Flask not installed

@app.get("/")
def root():
    return {"message": "Flask app at /flask/ if Flask is installed"}
