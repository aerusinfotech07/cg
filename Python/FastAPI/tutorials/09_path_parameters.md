# FastAPI - Path Parameters

## Basic Path Parameters

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/items/{item_id}")
def get_item(item_id: int):
    return {"item_id": item_id}
```

## Multiple Path Parameters

```python
@app.get("/users/{user_id}/items/{item_id}")
def get_user_item(user_id: int, item_id: str):
    return {"user_id": user_id, "item_id": item_id}
```

## Path Order

More specific paths must be defined before parameterized ones:

```python
@app.get("/items/me")
def read_me():
    return {"item": "me"}

@app.get("/items/{item_id}")
def read_item(item_id: str):
    return {"item_id": item_id}
```

## Enum Path

```python
from enum import Enum

class ModelName(str, Enum):
    a = "a"
    b = "b"

@app.get("/models/{model_name}")
def get_model(model_name: ModelName):
    return {"model": model_name}
```

## Next Steps

- [Query Parameters](10_query_parameters.md)
