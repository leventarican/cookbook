# we will use input, print and sys
import sys

print('################################################################################')
print('welcome to console app')
print('################################################################################')
print('type exit to exit.')

while True:
    response = input()
    if response == 'exit':
        print('exiting...')
        sys.exit()
