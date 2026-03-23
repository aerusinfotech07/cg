# FastAPI - Using GraphQL

## Strawberry or Ariadne

FastAPI can mount a GraphQL app. Example with **Strawberry**:

```python
import strawberry
from fastapi import FastAPI
from strawberry.fastapi import GraphQLRouter

@strawberry.type
class Query:
    @strawberry.field
    def hello(self) -> str:
        return "Hello World"

schema = strawberry.Schema(Query)
graphql_app = GraphQLRouter(schema)

app = FastAPI()
app.include_router(graphql_app, prefix="/graphql")
```

## Install

```bash
pip install strawberry-graphql
```

## Query at POST /graphql

```graphql
query { hello }
```

## Next Steps

- [WebSockets](29_websockets.md)
