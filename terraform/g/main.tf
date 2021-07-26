terraform {
  required_version = "1.0.1"
}

locals {
  numbers = [0, 1, 2]
  result = sum([for x in local.numbers : 1 * x])
  dirname = dirname("foo/bar/file.txt")
  fileexists = fileexists("${path.module}/data.txt")
  file64 = filebase64("${path.module}/data.txt")
  a = ["a", "b"]
  b = [1, 2]
}

output "a" {
  value = local.result
}

output "b" {
  value = local.dirname
}

output "c" {
  value = local.fileexists
}

output "d" {
  value = local.file64
}

//https://www.terraform.io/docs/language/expressions/strings.html#interpolation
output "e" {
  value = "timestamp: ${timestamp()}"
}

output "f" {
  value = zipmap(local.a, local.b)
}

output "g" {
  value = distinct([1, 1, 1, 2])
}

output "h" {
  value = parseint("010", 2)
}

output "i" {
  value = "###"
}