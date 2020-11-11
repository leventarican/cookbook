# https://www.codewars.com/kata/5656b6906de340bd1b0000ac/train/python

def longest(s1, s2):
    a = set(s1)
    b = set(s2)
    c = a.union(b)
    d = sorted(c)
    return "".join(d)

if __name__ == "__main__":
    assert(longest("aretheyhere", "yestheyarehere") == "aehrsty")