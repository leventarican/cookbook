# example need AWS credentials
# similar to example b but with getting the latest AMI image

provider "aws" {
  region = "us-west-2"
}

# get most recent AMI of ubuntu image
# element - type - name
data "aws_ami" "ubuntu" {
  most_recent = true

  filter {
    name = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-focal-20.04-amd64-server-*"]
  }

  # Canonical Ubuntu AWS account id
  owners = ["099720109477"]
}

resource "aws_instance" "helloworld" {
  # here we are using the data resource output
  ami = data.aws_ami.ubuntu.id

  instance_type = "t2.micro"
  tags = {
    Name = "HelloWorld"
  }
}