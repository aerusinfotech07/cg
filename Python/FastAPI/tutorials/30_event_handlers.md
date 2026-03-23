# FastAPI - Event Handlers

## startup and shutdown

```python
from fastapi import FastAPI

app = FastAPI()

@app.on_event("startup")
async def startup_event():
    print("Application starting...")
    # Open DB connection, load config, etc.

@app.on_event("shutdown")
async def shutdown_event():
    print("Application shutting down...")
    # Close DB, cleanup
```

## Lifespan (Alternative)

```python
from contextlib import asynccontextmanager

@asynccontextmanager
async def lifespan(app: FastAPI):
    # startup
    yield
    # shutdown

app = FastAPI(lifespan=lifespan)
```

## Next Steps

- [Mounting Sub-App](31_mounting_subapp.md)
