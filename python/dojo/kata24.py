def count_positives_sum_negatives(arr):
    print(len(arr))
    if len(arr) == 0:
        return []

    p = 0
    n = 0
    for i in arr:
        if i > 0:
            p = p + 1
        else:
            n = n + i
    print(p)
    print(n)

    return [p, n]

if __name__ == "__main__":
    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15]
    a = []
    b = count_positives_sum_negatives(a)
    print(b)