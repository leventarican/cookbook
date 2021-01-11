def abbrev_name(name):
    a = name.split(" ")
    b = f"{a[0][0].upper()}.{a[1][0].upper()}"
    print(b)
    return b

if __name__ == "__main__":
    a = abbrev_name("Sam Harris")
    assert(a, "S.H")
