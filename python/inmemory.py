import io

# https://docs.python.org/3/library/io.html#io.StringIO
# https://docs.python.org/2/library/stringio.html

output = io.StringIO()
output.write('First line.\n')
print('Second line.', file=output)

# Retrieve file contents -- this will be
# 'First line.\nSecond line.\n'
contents = output.getvalue()

with open("inmemory_stringio.file", "w") as f:
    f.write(contents)

# Close object and discard memory buffer --
# .getvalue() will now raise an exception.
output.close()
