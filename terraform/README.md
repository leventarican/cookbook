# Notes: Terraform in Action
* Terraform is an infrastructure as code provisioning tool
* Terraform is a highly expressive declarative programming language
* Declarative: Say what you want, not how to do it.
* Terraform is like AWS Cloudformation, GCP Deployment Manager, Azure Resource Manager
* Write code with domain-specific configuration language called HashiCorp Configuration Language (HCL)
* HCL is fully compatible with JSON
* __Providers__ are __plugins__ for Terraform that are designed to interface with external APIs.
* When Terraform runs, it will read all files in the working directory that have a .tf
  extension and __concatenate__ them together.
* Fundamentally, Terraform is a state management tool that performs
  CRUD operations (create, read, update, delete) on managed resources.
  
## Commands
```bash
# CRUD operations
terraform init
terraform plan - read
terraform apply - create / update
terraform destroy - delete
```

## Resources  
* Each resource has __inputs__ and __outputs__. Inputs are called __arguments__, and outputs are
  called __attributes__.
* Examples of __local-only__ resources include resources for creating private keys, self-signed TLS cer-
  tificates, and random ids.
  
## Providers
* Providers don’t have outputs—only inputs.  

## Data sources
* are elements that allow you ot fetch data at runtime and perform computations
