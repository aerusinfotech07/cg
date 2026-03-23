# FastAPI - Cookie Parameters

## Read Cookies

```python
from fastapi import FastAPI, Cookie

app = FastAPI()

@app.get("/")
def read_cookie(session_id: str | None = Cookie(None)):
    return {"session_id": session_id}
```

## Set Cookie in Response

```python
from fastapi import Response

@app.get("/set-cookie")
def set_cookie(response: Response):
    response.set_cookie(key="session_id", value="abc123")
    return {"message": "Cookie set"}
```

## Cookie with Default

```python
@app.get("/items")
def items(theme: str = Cookie("light")):
    return {"theme": theme}
```

## Next Steps

- [Header Parameters](20_header_parameters.md)
