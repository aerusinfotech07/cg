# FastAPI Uploading Files
from fastapi import FastAPI, File, UploadFile

app = FastAPI()

@app.post("/upload")
async def upload_file(file: UploadFile = File(...)):
    contents = await file.read()
    return {"filename": file.filename, "size": len(contents)}

@app.post("/upload-multiple")
async def upload_files(files: list[UploadFile] = File(...)):
    return [{"filename": f.filename} for f in files]
