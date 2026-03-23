# FastAPI - Header Parameters

## Read Headers

```python
from fastapi import FastAPI, Header

app = FastAPI()

@app.get("/")
def read_header(user_agent: str | None = Header(None)):
    return {"User-Agent": user_agent}
```

## Custom Header

```python
@app.get("/")
def read_custom(x_custom: str | None = Header(None)):
    return {"x_custom": x_custom}
```

## Convert Underscores

Headers like `X-Custom-Value` are normally read as `x_custom_value`. Use `convert_underscores=False` to keep original:

```python
x_custom: str | None = Header(None, convert_underscores=False)
```

## Next Steps

- [Response Model](21_response_model.md)
