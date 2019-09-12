print(
    '''
    set: a collection type of unordered, unique and immutable objects
    '''
)

f = set('foo')
print(f)
c = set('code')
print(c)

print('difference: {}'.format(f - c))
print('union: {}'.format(f | c))
print('intersection: {}'.format(f ^ c))
print('membership: {}'.format('o' in c))
