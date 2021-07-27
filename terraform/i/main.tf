data "external" "program" {
  #working_dir = path.module
  #program     = ["python", "example.py"]

  program = ["python", "${path.module}/example.py"]

  # input for python as json
  query = {
    a = "example-data"
  }

}

# access output json with .result.key0
output "code" {
  value = "# OUT: ${data.external.program.result.key0}"
}