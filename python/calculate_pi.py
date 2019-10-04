print('calculate pi')

example = 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11

def calculate() -> float:
    n = 4.0
    d = 1.0
    pi = n/d

    # numpy can step floats
    # for _ in range(d, 100.0, 2.0):
    #     pass

    for _ in range(100):
        d += 2.0
        pi -= n/d
        d += 2.0
        pi += n/d
    return pi

if __name__ == "__main__":
    result = calculate()
    print(result)