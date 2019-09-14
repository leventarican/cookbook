import json

data = 'numbers.json'

'''
store / write data structure as json
'''
numbers = [1, 2, 700, 30]
with open(data, 'w') as f:
    json.dump(numbers, f)
numbers = None

'''
read the data (json file)
'''
try:
    with open(data) as f:
        numbers = json.load(f)
    print(numbers)
except FileNotFoundError:
    print('ERROR: file not found.')
