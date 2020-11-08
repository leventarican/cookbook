def move_zeros(array):
    print(array)
    a = array.copy()
    z = 0
    # a = [array.pop(i-1) if type(x) is int and x==0 else x for i,x in enumerate(array)]
    for i,x in enumerate(array):
        if (type(x) is int and x==0) or (type(x) is float and x==0.0):  
            # print(f"x:{x}; i:{i}")
            a[i] = "#"
            z += 1
    r = "#"
    while r in a: a.remove(r)
    for x in range(0, z):
        a.append(0)
    print(a)
    return a

if __name__ == "__main__":
    # move_zeros([False,1,0,1,2,0,1,3,"a"]) # returns[False,1,1,2,1,3,"a",0,0]
    a = [False,1,0.0,1,2,0,1,3,"a"]
    a = [9, 0.0, 0, 9, 1, 2, 0, 1, 0, 1, 0.0, 3, 0, 1, 9, 0, 0, 0, 0, 9]
    a = [1, 2, 0, 1, 0, 1, 0, 3, 0, 1]
    move_zeros(a)
