import ctypes
import time

# python3 utils.py
#
# benchmark [c]: 1
# time [c]: 0.10637187957763672s
# benchmark [python]: 1
# time [python]: 4.775153875350952s

utils = ctypes.CDLL('/home/dev/root/cookbook/python/libutils.so')
# utils.square.argtype = (ctypes.c_int)
utils.square.argtype = (ctypes.c_long)

def square_c(x):
    global utils
    result = utils.square(ctypes.c_int(x))
    return result

def benchmark_c():
    result = utils.benchmark()
    return 'benchmark [c]: ' + str(result)

def benchmark_py():
    result = 0
    for i in range(10000000):
        result += 1
        result = (result * result) % 3
    return 'benchmark [python]: ' + str(result)

print(square_c(10))

start = time.time()
print(benchmark_c())
print("time [c]: {}s".format(time.time() - start))

start = time.time()
print(benchmark_py())
print("time [python]: {}s".format(time.time() - start))
