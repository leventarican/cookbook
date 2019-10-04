
# implementation of fibonacci sequence
# 0, 1, 1, 2, 3, 5, 8, 13, 21, ...

def fib(x: int, y: int):
    print(f'{x}, ', end='')
    if y > 21:
        return
    fib(y, x+y)

if __name__ == "__main__":
    fib(0,1)