# examples runs locally but to network call
terraform {
  required_version = ">= 1.0.0"
  required_providers {
    local = {
      source = "hashicorp/local"
      version = "~> 2.0"
    }
    http = {
      source = "hashicorp/http"
      version = "2.1.0"
    }
  }
}

provider "http" {
  # Configuration options
}

# declaring local_file resource
# for CRUD operation on local file
resource "local_file" "literature" {
  filename = "art_of_war.txt"

  # indented heredoc string (between <<-EOT and EOT)
  content = <<-EOT
      Sun Tzu said: The art of war is of vital importance to the State.

      It is a matter of life and death, a road either to safety or to
      ruin. Hence it is a subject of inquiry which can on no account be
      neglected. UPDATE TEXT.
    EOT
}

module "foo" {
  source = "../a"

  a = ""
}

variable "b" {
  type = string
  default = "default-value #"
}

output "out" {
  value = "# ${module.foo.out.body}"
}