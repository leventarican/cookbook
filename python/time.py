from datetime import datetime, date
import time

# https://docs.python.org/3/library/datetime.html
# https://docs.python.org/3/library/time.html

def snippet0():
    now = datetime.utcnow()
    print(f"UTC now: {now}")

def snippet1():
    '''
    The epoch is the point where the time starts, and is platform dependent.
    '''
    print(f"time in seconds since the epoch as a floating point number: {time.time()}\n")

    epoch = time.gmtime(0)
    print(f"epoch time - January 1, 1970, 00:00:00 (UTC): {epoch}")

def snippet2():
    '''
    1541106106796 ms
    1610815231.4928594 s
    1610816236474.0793 ms

    https://docs.python.org/3/library/time.html#time.time
    '''
    # 
    a = time.time()
    b = date.fromtimestamp(a)

    c = 1541106106796
    d = date.fromtimestamp(c / 1000)
    e = datetime.fromtimestamp(c / 1000)
    f = str(datetime.fromtimestamp(int(c) / 1000))

    print(f"timestamp [s]: {a}")
    print(f"timestamp [ms]: {int(a * 1000)}")
    print(f"date (from timestamp [ms]): {d}")
    print(f"datetime (from timestamp [ms]): {e}")
    print(f"datetime (from timestamp [ms]): {f}")

if __name__ == "__main__":
    snippet0()
    snippet1()
    snippet2()