# example need AWS credentials
# terraform init
# terraform apply

provider "aws" {
  region = "us-west-2"
}

resource "aws_instance" "helloworld" {
  # inputs / arguments

  # ami = the image id
  ami = "ami-09dd2e08d601bff67"

  instance_type = "t2.micro"
  tags = {
    Name = "HelloWorld"
  }
}