# FastAPI - IDE Support

## Autocomplete and Type Checking

Because FastAPI uses type hints:

- **VS Code / Cursor** – Good autocomplete and inline docs
- **PyCharm** – Full support for routes and models
- **mypy** – Use for static type checking

## Install Type Stubs (optional)

```bash
pip install types-requests
```

## Pydantic in IDE

When you define Pydantic models, the IDE knows attribute types:

```python
from pydantic import BaseModel

class User(BaseModel):
    name: str
    age: int

# IDE knows user.name is str, user.age is int
def get_user() -> User:
    return User(name="Alice", age=25)
```

## Next Steps

- [REST Architecture](08_rest_architecture.md)
