import csv

def code1():
    with open('gapminder-FiveYearData.csv', 'r') as csvfile:
        csvreader = csv.reader(csvfile, delimiter=',')
        for i, row in enumerate(csvreader):
            country, year, pop, continent, lifeExp, gdpPercap = row
            print(year)

def code0():
    with open('1000000salesrecords.csv', newline='') as csvfile:
        csvreader = csv.reader(csvfile, delimiter=',')
        linecount = 0
        for row in csvreader:
            linecount += 1
        print('csvfile lines: {}'.format(linecount))

def main():
    # code0()
    code1()

if __name__ == '__main__':
    main()
