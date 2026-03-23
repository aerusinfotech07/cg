# Python REST API Development with Axios

This folder covers **building a Python REST API** (FastAPI) and **consuming it from the frontend using Axios** (JavaScript).

## Overview

- **Python (FastAPI)** – Backend REST API (GET, POST, PUT, DELETE)
- **Axios** – JavaScript HTTP client to call the API from browser or Node.js

## Installation

**Backend (Python):**
```bash
pip install fastapi uvicorn
```

**Frontend (Axios):**  
Include Axios via CDN in HTML, or install in a Node project:
```bash
npm install axios
```

## Structure

```
RestAPI-Axios/
├── README.md
├── TUTORIAL_INDEX.md
├── tutorials/          # Markdown tutorials
└── examples/           # Python API + HTML/JS Axios client
```

## Run the Full Example

1. Start the Python API (from project root or from `RestAPI-Axios/examples`):
   ```bash
   cd C:\Training\Python\RestAPI-Axios\examples
   uvicorn api_main:app --reload --port 8000
   ```

2. Open the frontend (Axios client) in a browser:
   - Open `examples/frontend/index.html` in a browser (file:// or via a local server).
   - The page calls `http://127.0.0.1:8000`; ensure the API is running and CORS is enabled.

See [TUTORIAL_INDEX.md](TUTORIAL_INDEX.md) for the full syllabus.
