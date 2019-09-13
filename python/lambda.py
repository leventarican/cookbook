print(
    '''
    lambda: anonymous functions
    lambdas generate function objects from expressions.
    lambda is an expression not a statement.
    '''
)

def func(x,y):
    return x+y
f = func(3,4)
print('function: {}'.format(f))

l = lambda x,y: x+y
print('lamda: {}'.format(l(3,4)))

def hello():
    prefix = 'hello'
    result = (lambda name: prefix + ' ' + name)
    return result

foo = hello()
print(foo)
print(foo('bar'))
