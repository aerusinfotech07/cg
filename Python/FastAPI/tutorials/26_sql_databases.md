# FastAPI - SQL Databases

## SQLAlchemy + FastAPI

```python
from fastapi import FastAPI, Depends
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, Session

DATABASE_URL = "sqlite:///./test.db"
engine = create_engine(DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

app = FastAPI()

@app.get("/items")
def get_items(db: Session = Depends(get_db)):
    # Use db to query
    return []
```

## Create Tables

```python
from sqlalchemy.ext.declarative import declarative_base
Base = declarative_base()
Base.metadata.create_all(bind=engine)
```

## Install

```bash
pip install sqlalchemy
```

## Next Steps

- [Using MongoDB](27_using_mongodb.md)
