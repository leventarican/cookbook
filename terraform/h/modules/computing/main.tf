locals {
  foo = join("", ["example", "data", "####"])
  bar = var.type == "python3_8" ? "python3.8" : "python3.7"
}

data "external" "shell" {
  program = [
    "sh",
    "${path.module}/example.sh",
    local.foo,
    var.type
  ]
}
