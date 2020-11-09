# https://www.codewars.com/kata/546f922b54af40e1e90001da/train/python

def alphabet_position(text):
    # start with index 1: a=1, b=2, ...
    abc = " abcdefghijklmnopqrstuvwxyz"

    a = text.lower()
    b = abc.find("t")
    c = [str(abc.find(char)) for char in a]
    while "-1" in c: c.remove("-1")
    while "0" in c: c.remove("0")
    d = " ".join(c)
    print(d)
    return d

if __name__ == "__main__":
    actual = "The sunset sets at twelve o' clock."
    expected = "20 8 5 19 21 14 19 5 20 19 5 20 19 1 20 20 23 5 12 22 5 15 3 12 15 3 11"
    assert(alphabet_position(actual) == expected)

# example 0
# return ' '.join(str(ord(c) - 96) for c in text.lower() if c.isalpha())

# example 1
# def alphabet_position(text):
#   al = 'abcdefghijklmnopqrstuvwxyz'
#   return " ".join(filter(lambda a: a != '0', [str(al.find(c) + 1) for c in text.lower()]))

# example 2
# def get_positions(text):
#     for char in text:
#         pos = ord(char)
#         if pos >= 65 and pos <= 90:
#             yield pos - 64
#         if pos >= 97 and pos <= 122:
#             yield pos - 96

# def alphabet_position(text):
#     return " ".join((str(char) for char in get_positions(text)))