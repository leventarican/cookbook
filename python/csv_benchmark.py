import csv

with open('1000000salesrecords.csv', newline='') as csvfile:
    csvreader = csv.reader(csvfile, delimiter=',')
    linecount = 0
    for row in csvreader:
        linecount += 1
    print('csvfile lines: {}'.format(linecount))
