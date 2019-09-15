def printLanguages():
    print('python')
    print('java')
    print('kotlin')
    print('cpp')
    print('js')

def printPI():
    print('pi: {}'.format(3.14))

def ping(pong):
    print('pong: {}'.format(pong))

# pass arbitary number of arguments
def arbitary(*programminglanguages):
    # programminglanuages is a tuple
    for pl in programminglanguages:
        print(f'- {pl}')

JAVA = 'java'
PY = 'python'
CPP = 'c++'

# printLanguages()
# printPI()
# ping('foobar')

arbitary(JAVA)
arbitary(CPP, PY)
