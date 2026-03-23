# FastAPI - Uvicorn

## What is Uvicorn?

**Uvicorn** is an ASGI server used to run FastAPI (and other ASGI apps). It is fast and supports async.

## Install

```bash
pip install uvicorn
```

## Run

```bash
# Basic
uvicorn main:app

# With reload (development)
uvicorn main:app --reload

# Host and port
uvicorn main:app --host 0.0.0.0 --port 8000

# From package path
uvicorn mypackage.main:app --reload
```

## Programmatic

```python
import uvicorn

if __name__ == "__main__":
    uvicorn.run("main:app", host="0.0.0.0", port=8000, reload=True)
```

## Next Steps

- [Type Hints](06_type_hints.md)
