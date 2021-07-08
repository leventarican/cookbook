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

resource "local_file" "literature" {
  filename = "art_of_war.txt"
  content = <<-EOT
      Sun Tzu said: The art of war is of vital importance to the State.

      It is a matter of life and death, a road either to safety or to
      ruin. Hence it is a subject of inquiry which can on no account be
      neglected.
    EOT
}

module "foo" {
  source = "./a"

  a = ""
}

variable "b" {
  type = string
  default = "default-value #"
}

output "out" {
  value = "# ${module.foo.out.body}"
}