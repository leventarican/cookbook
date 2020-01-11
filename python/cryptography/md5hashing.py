import hashlib

# example one-way function
md5hash = hashlib.md5(b'bob').hexdigest()
print(md5hash)
