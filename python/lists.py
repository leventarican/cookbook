# lists are mutable
jvm = ['java', 'kotlin']
languages = ['python', jvm, 42, 'cpp']
for l in languages:
    print(l)
print('languages[1][0]: ' + languages[1][0])

print('')
numbers = [42, 20, 100, 1, 3]
numbers.sort()
print(numbers)

print('')
# strings are immutable
python = 'python'
print(python[0])
print(python[4])
print(python[-4])
print(python[0:2])
