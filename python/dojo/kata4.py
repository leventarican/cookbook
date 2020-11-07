from functools import reduce

def summation(num):
    a = [x for x in range(0, num+1)]
    b = reduce(lambda x,y: x+y, a)
    print(b)
    return b

# return sum(range(1,num+1))

if __name__ == "__main__":
    assert(summation(8) == 36)