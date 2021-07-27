module "computing" {
  //meta arguments
  source = "./modules/computing"
  count = 2

  // input
  foo = 100
}

module "networking" {
  source = "./modules/networking"

  config = {
    user = "foo"
    pass = "bar"
    hostname = "localhost"
    port = "8080"
  }
}

variable "root-variable" {
  type = number
  default = 100
}

locals {
  msg = "${timestamp()} - INFO#"
}

output "root-out" {
  value = "${local.msg} ${var.root-variable}"
}

output "computing-out" {
  //value = module.computing[0].ga-out
  value = module.computing
}

output "networking-out" {
  value = module.networking
}

output "networking-out-data" {
  value = module.networking.networking-out-data.content
}