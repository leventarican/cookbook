dev = { 'lan': 'python', 'exp': 42}
print(dev)

print('lan' in dev.keys())
print('python' in dev.values())
print(dev.get('exp'))

root = {}
root['id'] = 0
root['programminglanguage'] = 'java'
datatypes = []
root['datatypes'] = datatypes
syntax = []
root['syntax'] = syntax
syntax.append(['System.out.println()', 'class Foobar'])
datatypes.append('Integer')
datatypes.append('String')
datatypes.append('Double')
print(root)

def wordcount(fname):
    try:
        fhand = open(fname)
    except Exception as e:
        print('file could not opened')
        exit()
    count = dict()
    for line in fhand:
        tokens = line.split()
        for token in tokens:
            if token not in count:
                count[token] = 1
            else:
                count[token] += 1
    return (count)

if __name__ == '__main__':
    fname = 'sample.txt'
    count = wordcount(fname)
    print(count)
