# outputs

output "networking-out" {
  value = "# networking out"
}

output "networking-out-data" {
  value = data.local_file.data
}