# https://stackoverflow.com/questions/25944010/python-benchmarking-disk-write-exactly-x-bytes-in-a-file
from time import perf_counter as pc
import os
def write_test_1(block_size, blocks_count):
    file = 'write_speed_1.file'
    f = os.open(file, os.O_CREAT|os.O_WRONLY, 0o777) # low-level I/O

    took = []
    for i in range(blocks_count):
        buff = os.urandom(block_size) # get random bytes
        start = pc()
        os.write(f, buff)
        os.fsync(f) # force write to disk
        t = pc() - start
        took.append(t)

    os.close(f)
    return took

# https://stackoverflow.com/questions/25944010/python-benchmarking-disk-write-exactly-x-bytes-in-a-file
# calculate latency (ms) and throughput (MB/s)
import sys
import time
def write_test_0(block_size):
    start_time = time.time()

    # chunk = b'\xff'*10000
    chunk = b'\xff'
    with open("write_speed_0.file", "wb") as f:
        # for _ in range(block_size // 10000):
        for _ in range(block_size):
            f.write(chunk)

    stop_time = time.time()
    diff = stop_time - start_time
    print(diff)
    print(block_size/diff)

if __name__ == '__main__':
    block_size = int(sys.argv[1])
    blocks_count = int(sys.argv[2])

    write_test_0(block_size)
    t = write_test_1(block_size, blocks_count)
    print(t)

# python3 write_speed.py 10000000 1
# 9.00178575515747    for writing 10MB file
# 1110890.6912465245  byte/s
# [0.057140463000905584]  for writing 10MB file
