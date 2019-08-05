import pandas as pd

def main():
    print("use pandas for reading csv with chunk")

    csv = "unconventional.csv"
    # chunk (line) size
    c_size = 100

    # load the big file in smaller chunks
    for gm_chunk in pd.read_csv(csv, chunksize=c_size):
        # print(gm_chunk.shape)
        print(gm_chunk['lifeExp'])

if __name__ == '__main__':
    main()
