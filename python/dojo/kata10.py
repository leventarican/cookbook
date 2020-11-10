# https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/python

def get_count(input_str):
    vowels = "aeiou"
    input_str = input_str.replace(" ", "")
    num_vowels = [1 if vowels.find(c) > -1 else -1 for c in input_str].count(1)
    return num_vowels

if __name__ == "__main__":
    assert(get_count("abracadabra") == 5)
    assert(get_count("") == 0)
    assert(get_count("pear tree") == 4)

# def getCount(s):
#     return sum(c in 'aeiou' for c in s)
