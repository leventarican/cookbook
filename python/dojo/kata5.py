def accum(s):
    a = "".join([v.upper()+v.lower()*(k)+"-" if k!=len(s)-1 else v.upper()+v.lower()*(k) for k,v in enumerate(s)])
    print(a)
    return a

# return '-'.join(c.upper() + c.lower() * i for i, c in enumerate(s))

if __name__ == "__main__":
    actual = "ZpglnRxqenU"
    expected = "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu"
    assert(accum(actual) == expected)
