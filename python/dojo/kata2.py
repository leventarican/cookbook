def to_jaden_case(string):
    a = string.split(" ")
    b = list(map(lambda x: x[0].upper()+x[1:], a))
    c = " ".join(b)

    # string.title() doesnt recognize edge case -> Aren'T | Aren't
    print(c)
    return c

# return " ".join(w.capitalize() for w in string.split())

if __name__ == "__main__":
    actual = "How can mirrors be real if our eyes aren't real"
    expected = "How Can Mirrors Be Real If Our Eyes Aren't Real"
    # to_jaden_case(actual)
    assert(to_jaden_case(actual) == expected)
