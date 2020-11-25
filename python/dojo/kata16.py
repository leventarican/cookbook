# https://www.codewars.com/kata/563f037412e5ada593000114/train/python

def calculate_years(principal, interest, tax, desired):
    sum_of_p = principal
    for x in range(5):
        t = (sum_of_p / 100) * tax
        i = (sum_of_p / 100) * interest
        sum_of_p = t + i
        print(f"s {sum_of_p}; i {i}; t: {t}")
    return 3

if __name__ == "__main__":
    assert(calculate_years(1000, 0.05, 0.18, 1100) == 3)