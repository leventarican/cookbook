# https://www.codewars.com/kata/54ba84be607a92aa900000f1/train/python

def is_isogram(string):
    a = string.lower()
    a = list(a)
    a.sort()
    print(a)
    b = set(a)
    b = list(b)
    b.sort()
    print(b)
    return len(a) == len(b)

if __name__ == "__main__":
    assert(is_isogram("Dermatoglyphics") == True)
    assert(is_isogram("moOse") == False)