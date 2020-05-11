# string can be enconded either text or bytes.

raw_string = r'raw string will ignore escape \n characters.'
print(raw_string)

multiline_string = '''hello world,

how are you?

regards,
dev
'''
print(multiline_string)

upper_lower_string = 'learn python in 60s'
print(upper_lower_string.upper())
print(upper_lower_string.upper().lower())

# since Python 3.6
python = 'python'
f_string = f"f string work since {python} {3.6}"
print(f_string)

# before Python 3.6
# %-formatting 
print('hello %s %s' % (python, python))

# str.format()
version = 2.6
print("hello {}".format(python))
print("str.format introduced in {1} version {0}".format(version, python))
