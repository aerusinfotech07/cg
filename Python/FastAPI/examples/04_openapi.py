# FastAPI OpenAPI - custom schema
from fastapi import FastAPI

app = FastAPI(
    title="Demo API",
    description="API with automatic OpenAPI docs",
    version="1.0.0",
)

@app.get("/")
def root():
    return {"message": "Visit /docs for Swagger UI"}
