# FastAPI Using GraphQL - requires: pip install strawberry-graphql
# Then: from strawberry.fastapi import GraphQLRouter; app.include_router(GraphQLRouter(schema), prefix="/graphql")
from fastapi import FastAPI

app = FastAPI()

@app.get("/")
def root():
    return {"message": "Install strawberry-graphql and add GraphQL schema + router"}
