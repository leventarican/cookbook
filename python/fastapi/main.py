from fastapi import FastAPI
from typing import List
from pydantic import BaseModel, Field
from fastapi.openapi.utils import get_openapi

app = FastAPI()

todos = ["Finish homework", "Buy groceries", "Go for a run"]

class getTodosResponse(BaseModel):
    todos: List[str] = Field(description="The list of todos.")

@app.get("/todos", response_model=getTodosResponse, summary="Get the list of todos")
async def get_todos():
    return {"todos": todos}

def custom_openapi():
    servers = [{"url": "https://localhost:8000"}]
    contact = {"name": "Duke", "email": "duke@example.com"}

    if app.openapi_schema:
        return app.openapi_schema
    openapi_schema = get_openapi(
        title="TODO Plugin",
        version="4.2.0",
        description="A plugin that allows the user to create and manage a TODO list using ChatGPT.",
        routes=app.routes,
        servers=servers,
        contact=contact,
    )
    app.openapi_schema = openapi_schema
    return app.openapi_schema


app.openapi = custom_openapi