# https://www.codewars.com/kata/569d488d61b812a0f7000015/train/python

# A stream of data is received and needs to be reversed.

def data_reverse(data):
    n = len(data) // 8
    l = []
    for i in range(n):
        a = data[8*i:8*(i+1):1]
        l.insert(0, a)
    f = sum(l, [])
    print(f)
    return f

if __name__ == "__main__":
    data1 = [1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]
    data2 = [1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1]
    assert(data_reverse(data1) == data2)

# return [b for a in xrange(len(data) - 8, -1, -8) for b in data[a:a + 8]]
