# https://www.codewars.com/kata/5262119038c0985a5b00029f/train/python

# per wikipedia, a prime number (or a prime) is a natural number greater than 1 
# that has no positive divisors other than 1 and itself.

import math

def inefficient_algorithm(num):
    for x in range(2,num):
        a = num % x
        if a == 0:
            return False
    return True

def inefficient_algorithm_(num):
    a = num-1
    print(a)
    for x in range(2,a):
        for y in range(x,a):
            # print(f"x:{x}; y:{y} = {x*y}")
            if x*y == num:
                return False

# use memoisation
# from functools import lru_cache

# @lru_cache(maxsize=None)
def is_prime(num):
    print(num)
    if num <= 1:
        return False

    # inefficient_algorithm(num)
    # inefficient_algorithm_(num)

    a = int(math.sqrt(num))
    # print(a)

    for x in range(2, a+1):
        # print(f"x: {x}")
        if num % x == 0:
            return False

    print(f"prime: {num}")
    return True

if __name__ == "__main__":
    assert(is_prime(4) == False)
    assert(is_prime(73) == True)
    assert(is_prime(5099) == True)
    assert(is_prime(45) == False)
    assert(is_prime(0) == False)
    assert(is_prime(1) == False)
    assert(is_prime(219181023) == False)
