dev_lang = 'python'
if dev_lang == 'python':
    print('dev develops in python')
else:
    print('dev should learn python')

dev_exp = 20
if dev_exp < 20:
    print('junior')
elif dev_exp > 20 and dev_exp < 42:
    print('senior')
else:
    print('tech lead')

# multiple conditions
if dev_exp == 20 and dev_lang == 'python':
    print('thats me')

# loops
coffee = 3
while coffee > 0:
    print('code...')
    coffee = coffee - 1

programminglanguages = ['python', 'java', 'kotlin']
for lang in programminglanguages:
    print(lang)

for i in range(10):
    print(i)

for i in (0,4):
    for i in (1,10):
        print(i)

if 'java' in programminglanguages:
    print('java found')
elif 'cpp' in programminglanguages:
    print('cpp found')
