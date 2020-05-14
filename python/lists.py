print('''
# lists are mutable
''')

jvm = ['java', 'kotlin']
languages = ['python', jvm, 42, 'cpp']
for l in languages:
    print(l)
print('languages[1][0]: ' + languages[1][0])

print('')
numbers = [42, 20, 100, 1, 3]
numbers.sort()
print(numbers)
print(f'number of elements: {len(numbers)}')
print(f'elements 1-3: {numbers[1:3]}')
numbers.append(200)
print(f'mutable (append a number): {numbers}')
numbers.insert(2, 200)
print(f'mutable (insert a number in specific index): {numbers}')
print(f'count of number 200: {numbers.count(200)}')

print('\n# strings are immutable')
python = 'python'
print(python[0])
print(python[4])
print(python[-4])
print(python[0:2])
print(python[:-3])
print(f"steps=-2: {python[::-2]}")
print(f"steps=1: {python[::1]}")
