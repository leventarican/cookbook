# Description
Demonstration of modules, ...

The _root module_ contains following files:
```bash
* main.tf
* terraform.tfvars
* data.json
```

In this directory you can run terraform.
```bash
terraform apply --auto-approve
```

The root module contains two child modules:
* computing
* networking
    * has a resource _local_file_

Both child modules have input's and output's.
