import re

pattern = '[A-Z]+([a-z]+)'
txt = 'KOTLINpythonJAVA'

print txt
print pattern

p = re.compile(pattern)
print p.match(txt).span(0)
print p.match(txt).group(0)

result = re.search(pattern, txt)
print result.span(1)
print result.group(1)