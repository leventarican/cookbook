def positive_sum(arr):
    a = [i for i in arr if i > 0]
    print(a)
    return sum(a)

if __name__ == "__main__":
    a = [1,-4,7,12]
    assert(positive_sum(a) == 20)