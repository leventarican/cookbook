# Python Packages
When your application has dependencies you need to install the packages with `pip`.
`pip` is an installer program. Example pip commands:
```bash
python3 -m pip --version
pip install pygame
```

If you try to run without installing dependencies you will receive an error.
```bash
ModuleNotFoundError: No module named 'requests'
```

Alternativly you can provide a `requirement.txt` with all package dependencies.
Install all packages listed there with the following command:
```bash
# Optional: create a virtual environment which we can delete afterwards.
python3 -m venv demo
source demo/bin/activate

# now within the virtual environment we install the dependencies.
pip install -r requirements.txt

# the packages are now available in the following path: 
ls demo/lib/python3.8/site-packages/

# the app is now ready to run
python3 app.py
```

## AWS Lambda 
If you want to create a _deployment package_ for AWS Lambda, then you can create a zip file with the dependencies and add the `app.py` in the zip file.

```bash
pip install --target ./package requests
```

* https://docs.aws.amazon.com/lambda/latest/dg/python-package.html#python-package-create-package-with-dependency
* https://www.jbssolutions.com/resources/blog/docker-aws-lambda/
