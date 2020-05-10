import urllib.request

URL = 'http://www.python.org/'
BYTES = 900

print(f'request {URL} and get {BYTES} bytes')

with urllib.request.urlopen(URL) as f:
    print(f.read(BYTES))
