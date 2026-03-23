# FastAPI - REST Architecture

## REST in FastAPI

FastAPI maps HTTP methods to Python functions:

| Method | Decorator | Use |
|--------|-----------|-----|
| GET | `@app.get()` | Read |
| POST | `@app.post()` | Create |
| PUT | `@app.put()` | Replace |
| PATCH | `@app.patch()` | Partial update |
| DELETE | `@app.delete()` | Delete |

## Example

```python
from fastapi import FastAPI

app = FastAPI()

@app.get("/items")
def list_items():
    return {"items": []}

@app.post("/items")
def create_item(item: dict):
    return {"created": item}

@app.get("/items/{item_id}")
def get_item(item_id: int):
    return {"item_id": item_id}

@app.delete("/items/{item_id}")
def delete_item(item_id: int):
    return {"deleted": item_id}
```

## Next Steps

- [Path Parameters](09_path_parameters.md)
