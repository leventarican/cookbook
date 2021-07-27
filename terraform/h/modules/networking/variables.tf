// inputs
variable "config" {
  type = object({
    user = string
    pass = string
    hostname = string
    port = string
  })
}