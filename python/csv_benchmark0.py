import time
import csv
import pandas as pd

# python3 csv_benchmark0.py
# time: 2.105673313140869s
# time: 0.6401224136352539s

def csv_dictreader():
    array = []
    with open("random.csv") as csvfile:
        data = csv.DictReader(csvfile, delimiter=';')
        for row in data:
            array.append(float(row['H']))
    return array

def csv_pandas():
    data = pd.read_csv("random.csv")
    for row in data:
        pass

start = time.time()
array = csv_dictreader()
print(len(array))
print("time: {}s".format(time.time() - start))

start = time.time()
csv_pandas()
print("time: {}s".format(time.time() - start))
