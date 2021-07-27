output "computing-out" {
  value = "# computing out; variable foo: ${var.foo}"
}

output "computing-out1" {
  value = data.external.shell.result
}