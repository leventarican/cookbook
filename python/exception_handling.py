def divide(by):
    try:
        print(42/by)
    except ZeroDivisionError:
        print('with quantum computing divide by zero will be available')

divide(3)
divide(0)
