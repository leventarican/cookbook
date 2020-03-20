import os

file = 'tmp.file'
file_check = os.path.isfile(file)
print(f'is file: {file_check}')

if file_check:
    text = open(file).read().rstrip()
    print(text)
