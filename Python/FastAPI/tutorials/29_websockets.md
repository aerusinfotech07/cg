# FastAPI - WebSockets

## WebSocket Endpoint

```python
from fastapi import FastAPI, WebSocket

app = FastAPI()

@app.websocket("/ws")
async def websocket_endpoint(websocket: WebSocket):
    await websocket.accept()
    while True:
        data = await websocket.receive_text()
        await websocket.send_text(f"Echo: {data}")
```

## Client (JavaScript)

```javascript
const ws = new WebSocket("ws://localhost:8000/ws");
ws.onmessage = (e) => console.log(e.data);
ws.send("Hello");
```

## Next Steps

- [Event Handlers](30_event_handlers.md)
