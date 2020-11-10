# https://www.codewars.com/kata/56606694ec01347ce800001b/train/python

import math

def is_triangle(a, b, c):
    # https://en.wikipedia.org/wiki/Triangle_inequality
    x = (a+b) > c
    y = (b+c) > a
    z = (a+c) > b
    return x & y & z

if __name__ == "__main__":
    assert(is_triangle(1, 2, 2) == True)
    assert(is_triangle(-1, 2, 3) == False)
    assert(is_triangle(0, 2, 3) == False)

# return (a<b+c) and (b<a+c) and (c<a+b)