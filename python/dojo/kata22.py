# https://www.codewars.com/kata/56676e8fabd2d1ff3000000c/train/python

def find_needle(haystack):
    a = [i for i,n in enumerate(haystack) if n == "needle"][0]
    a = f"found the needle at position {a}"
    print(a)
    return a

if __name__ == "__main__":
    a = ['3', '123124234', None, 'needle', 'world', 'hay', 2, '3', True, False]
    e = "found the needle at position 3"
    assert(find_needle(a) == e)
