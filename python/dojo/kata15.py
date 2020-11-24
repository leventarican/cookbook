# https://www.codewars.com/kata/5663f5305102699bad000056/train/python

# m = max(abs(len(a1[0]) − len(a2[0])))
def mxdiflg(a1, a2):
    if len(a1) == 0:
        return -1
    if len(a2) == 0:
        return -1
    a1_maxmin = abs(len(max(a1, key=lambda x: len(x))) - len(min(a2, key=lambda x: len(x))))
    a2_maxmin = abs(len(max(a2, key=lambda x: len(x))) - len(min(a1, key=lambda x: len(x))))
    if a1_maxmin > a2_maxmin:
        return a1_maxmin
    else:
        return a2_maxmin

if __name__ == "__main__":
    s1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"]
    s2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
    assert(mxdiflg(s1, s2) == 13)
    s1 = ['ejjjjmmtthh', 'zxxuueeg', 'aanlljrrrxx', 'dqqqaaabbb', 'oocccffuucccjjjkkkjyyyeehh']
    s2 = ['bbbaaayddqbbrrrv']
    assert(mxdiflg(s1, s2) == 10)

# def mxdiflg(a1, a2):
#     if a1 and a2:
#         return max(abs(len(x) - len(y)) for x in a1 for y in a2)
#     return -1
