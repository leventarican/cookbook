cookbook: python
================
* basics
* flow control
* import modules

* csv benchmark
  * count 1.000.000 csv file lines
```
time python3 csvbenchmark.py
csvfile lines: 1000001

real	0m13.041s
user	0m12.796s
sys	0m0.140s
```
  * write speed
```
python3 write_speed.py 10000000 1
9.00178575515747    for writing 10MB file
1110890.6912465245  byte/s
[0.057140463000905584]  for writing 10MB file
```
