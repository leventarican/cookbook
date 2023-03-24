
Example OpenAPI plugin with `fastAPI`. OpenAPI spec is automatically generated.
* https://platform.openai.com/docs/plugins/getting-started

# run
```bash
uvicorn main:app --reload

curl localhost:8000/todos | json_pp

# response
{
   "todos" : [
      "Finish homework",
      "Buy groceries",
      "Go for a run"
   ]
}
```

# OpenAPI
* swagger UI: http://localhost:8000/docs
* redocly: http://localhost:8000/redoc
* openapi: http://localhost:8000/openapi.json

# install
```bash
pip install "fastapi[all]"
```

# development setup
* Python 3.9.2
