def count_sheeps(sheep):
    print(sheep)
    a = len([s for s in sheep if s == False])
    b = len([s for s in sheep if s == None])
    c = len(sheep) - (a + b)
    return c

# return arrayOfSheeps.count(True)

if __name__ == "__main__":
    array1 = [True,  True,  True,  False,
            True,  True,  True,  True ,
            True,  False, True,  False,
            True,  False, False, True ,
            True,  True,  True,  True ,
            False, False, True,  True ];

    assert(count_sheeps(array1) == 17)