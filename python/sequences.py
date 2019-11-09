# sequences: string, list and tuples
# index, slicing and slice

def start_stop_step():
    x = (0,1,2,3,4,5,6,7,8,9)
    print(x[::])
    print(x[::-1])
    print(x[3::-1])
    print(x[:3:-1])

    s = slice(0,5,2)
    print(s)
    print(s.step)
    print(x[s])

def start_stop():
    x = (0,1,2,3,4,5,6,7,8,9)
    print(x[:])
    print(x[0:3])   # stop exclusive index 3
    print(x[5:6])
    print(f'slicing returns a sequence: {x[5:6][0]}')
    print(x[5:-4])
    print(x[-2:-1])

def index():
    x = (0,1,2,3,4,5,6,7,8,9)
    # slice step cannot be zero
    # print(x[3:5:0])

    print(f'5. last item: {x[-5]}')
    print(f'5. item: {x[5]}')
    print(f'last item: {x[-1]}')

def tuple_immutable():
    try:
        x = (0,1,2,3,4,5,6,7,8,9,10,11,12)
        x[7] = 42
        print(x)
    except TypeError:
        print('tuple is immutable')

def list_mutable():
    computer = ['cpu', 'memory', 'disk']
    computer[0] = 'gpu'
    print(computer)

def string_immutable():
    try:
        s = 'python'
        s[0] = 'x'
        print(s)
    except TypeError:
        print('string is immutable')

if __name__ == "__main__":
    string_immutable()
    list_mutable()
    tuple_immutable()
    index()
    start_stop()
    start_stop_step()
