# https://www.codewars.com/kata/52fba66badcd10859f00097e/train/python

def disemvowel(string):
    print(string)
    a = "".join([i for i in string if (i not in ['O', 'I', 'a', 'u', 'o', 'e', 'i'])])
    print(a)
    return a

if __name__ == "__main__":
    actual = "This website is for losers LOL!"
    expected = "Ths wbst s fr lsrs LL!"
    assert(disemvowel(actual) == expected)
