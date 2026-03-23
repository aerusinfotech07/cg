# FastAPI - Uploading Files

## Single File

```python
from fastapi import FastAPI, File, UploadFile

app = FastAPI()

@app.post("/upload")
async def upload_file(file: UploadFile = File(...)):
    contents = await file.read()
    return {"filename": file.filename, "size": len(contents)}
```

## Multiple Files

```python
@app.post("/upload-multiple")
async def upload_files(files: list[UploadFile] = File(...)):
    return [{"filename": f.filename} for f in files]
```

## Save to Disk

```python
@app.post("/upload-save")
async def save_upload(file: UploadFile = File(...)):
    path = f"uploads/{file.filename}"
    with open(path, "wb") as f:
        f.write(await file.read())
    return {"saved": path}
```

## Next Steps

- [Cookie Parameters](19_cookie_parameters.md)
