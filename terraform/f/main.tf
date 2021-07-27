terraform {
  required_version = "1.0.1"
  required_providers {
    random = {
      source = "hashicorp/random"
      version = "~> 3.0"
    }
  }
}

variable "words" {
  description = "a word pool"
  type = object({
    nouns = list(string)
    adjectives = list(string)
    verbs = list(string)
    adverbs = list(string)
    numbers = list(number)
  })
  validation {
    condition = length(var.words["nouns"]) >= 10
    error_message = "At least 10 nouns should supplied."
  }
}

resource "random_shuffle" "random_nouns" {
  input = var.words["nouns"]
}
resource "random_shuffle" "random_adjectives" {
  input = var.words["adjectives"]
}
resource "random_shuffle" "random_verbs" {
  input = var.words["verbs"]
}
resource "random_shuffle" "random_adverbs" {
  input = var.words["adverbs"]
}
resource "random_shuffle" "random_numbers" {
  input = var.words["numbers"]
}

output "mad_libs" {
  value = templatefile("${path.module}/templates/alice.txt",
  {
    nouns = random_shuffle.random_nouns.result
    adjectives = random_shuffle.random_adjectives.result
    verbs = random_shuffle.random_verbs.result
    adverbs = random_shuffle.random_adverbs.result
    numbers = random_shuffle.random_numbers.result
  })
}