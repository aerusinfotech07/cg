# FastAPI - Response Model

## Declare Response Model

```python
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class UserOut(BaseModel):
    name: str
    email: str

@app.get("/user", response_model=UserOut)
def get_user():
    return {"name": "Alice", "email": "alice@example.com"}
```

FastAPI validates and serializes the response to match `UserOut`.

## Exclude Unset/None

```python
@app.get("/user", response_model=UserOut, response_model_exclude_unset=True)
def get_user():
    return {"name": "Alice"}  # email can be omitted
```

## Exclude Fields

```python
response_model_exclude={"password"}
```

## Next Steps

- [Nested Models](22_nested_models.md)
