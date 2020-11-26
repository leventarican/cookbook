# https://www.codewars.com/kata/563f037412e5ada593000114/train/python

def calculate_years(principal, interest, tax, desired):
    p = principal
    y = 0
    while p < desired:
        y = y + 1
        a = p * interest
        p = p + a - a * tax
    print(y)
    return y

if __name__ == "__main__":
    assert(calculate_years(1000, 0.05, 0.18, 1100) == 3)