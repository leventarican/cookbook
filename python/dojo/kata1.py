# https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/train/python

# if a char appears once: ( 
# else: )

def duplicate_encode(word):
    word = word.lower()
    counts = [word.count(c) for c in word]
    encoded = "".join(["(" if i==1 else ")" for i in counts])
    print(encoded)
    return encoded

assert (duplicate_encode("abc") == "(((")
assert (duplicate_encode("recede") == "()()()")
assert (duplicate_encode("Success") == ")())())")
assert (duplicate_encode("(( @") == "))((")

# def duplicate_encode(word):
#     return "".join(["(" if word.lower().count(c) == 1 else ")" for c in word.lower()])
