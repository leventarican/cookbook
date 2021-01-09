def digitize(n):
    a = [int(s) for s in str(n)]
    a.reverse()
    print(a)
    return a

if __name__ == "__main__":
    assert(digitize(348597) == [7,9,5,8,4,3])