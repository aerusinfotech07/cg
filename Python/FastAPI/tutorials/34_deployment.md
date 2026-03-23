# FastAPI - Deployment

## Production with Uvicorn

```bash
uvicorn main:app --host 0.0.0.0 --port 8000 --workers 4
```

## Gunicorn + Uvicorn Workers

```bash
gunicorn main:app -w 4 -k uvicorn.workers.UvicornWorker -b 0.0.0.0:8000
```

## Docker

```dockerfile
FROM python:3.11-slim
WORKDIR /app
COPY requirements.txt .
RUN pip install -r requirements.txt
COPY . .
CMD ["uvicorn", "main:app", "--host", "0.0.0.0", "--port", "8000"]
```

## Environment Variables

Use `os.getenv()` or Pydantic `Settings` for config (e.g. database URL, secrets).

## Cloud

- **Railway, Render, Fly.io** – support Python/uvicorn
- **AWS, GCP, Azure** – container or serverless (e.g. Mangum for Lambda)

## Next Steps

- Return to [TUTORIAL_INDEX](../TUTORIAL_INDEX.md)
