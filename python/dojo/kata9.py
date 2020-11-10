def data():
    for x in range(0, 3):
        yield x

def code():
    a = [x for x in data()]
    print(a)

if __name__ == "__main__":
    code()