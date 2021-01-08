# https://www.codewars.com/kata/554b4ac871d6813a03000035/train/python

def high_and_low(numbers):
    a = numbers.split(" ")
    b = [int(i) for i in a]
    mx = max(b)
    mn = min(b)
    c = f"{mx} {mn}"
    print(c)

    return c

if __name__ == "__main__":
    a = "4 5 29 54 4 0 -214 542 -64 1 -3 6 -6"
    # a = "1 2 -3 4 5"
    high_and_low(a)
