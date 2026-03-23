# FastAPI SQL Databases - SQLAlchemy pattern
from fastapi import FastAPI, Depends
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, Session

DATABASE_URL = "sqlite:///./fastapi_sql_demo.db"
engine = create_engine(DATABASE_URL, connect_args={"check_same_thread": False})
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
    return {"items": []}  # Replace with actual ORM query
