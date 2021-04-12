import pandas as pd
import csv

print("ready.")

# read csv with: separator=;, skip rows, set encoding, no warning, ...
df = pd.read_csv('ignore-data.csv', sep=';', skiprows=12, error_bad_lines=False, warn_bad_lines=False, encoding='latin-1')

# select by column name
#print(df[["Colum0", "Colum1"]])

# select column by index
df = df.iloc[:, [0, 3, 11, 12]]

df = df[df.iloc[:, 3] == "S"]
print(df.head())

# write dataframe to file
df.to_csv(r'ignore-out.csv', header=None, index=None, sep=' ', mode='a')