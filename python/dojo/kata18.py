# https://www.codewars.com/kata/5ac6932b2f317b96980000ca/train/python

def min_value(digits):
    a = [str(d) for d in digits] 
    b = set(a)
    c = sorted(b)
    d = "".join(c)
    print(d)
    return int(d)

if __name__ == "__main__":
    a = [1, 3, 1]
    min_value(a)

# minValue = lambda a: int(''.join(sorted(str(c) for c in set(a))))