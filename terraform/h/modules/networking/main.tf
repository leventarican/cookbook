data "local_file" "data" {
  filename = "${path.root}/data.json"
}

locals {
  data = toset(["kotlin", "java", "python", "dart"])
}

// create a file for each item in the set
// as filename append the item in the set
// use content from data.json as content in the new file
resource "local_file" "data-new" {
  for_each = local.data
  filename = "${path.root}/data-${each.value}.json"
  content = data.local_file.data.content
}