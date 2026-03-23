# FastAPI Tutorials

FastAPI is a modern, fast web framework for building APIs with Python. This folder contains topic-wise tutorials with runnable examples.

## Installation

```bash
pip install fastapi uvicorn
```

## Structure

```
FastAPI/
├── README.md
├── TUTORIAL_INDEX.md
├── tutorials/          # Markdown tutorials
└── examples/           # Runnable Python examples
```

## Run Examples

```bash
# From Python folder - run a FastAPI app with Uvicorn
uvicorn FastAPI.examples.03_hello_world:app --reload
```

## Topics

- Intro, Hello World, OpenAPI, Uvicorn, Type Hints, IDE Support
- REST, Path/Query Parameters, Validation, Pydantic, Request Body
- Templates, Static Files, Forms, File Upload
- Cookies, Headers, Response Model, Nested Models
- Dependencies, CORS, CRUD, SQL, MongoDB, GraphQL
- WebSockets, Event Handlers, Sub-App, Middleware, Flask Mount, Deployment

See [TUTORIAL_INDEX.md](TUTORIAL_INDEX.md) for the full syllabus.
