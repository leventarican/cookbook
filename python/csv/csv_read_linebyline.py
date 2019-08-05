inputfile = open('unconventional0.csv', 'r')

signals = []

for line in range(4):
    inputfile.readline()

for line in inputfile:
    tokens = line.split(';')
    for token in tokens:
        try:
            signals.append(float(token.replace(',', '.')))
            # signals.append(token.replace(',', '.'))
            # signals.append(token)
        except Exception as e:
            pass

# print(signals)

inputfile.close()
