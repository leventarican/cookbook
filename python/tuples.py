print('''
* tuples supports oppertations as in string / lists
* tuples dont have the methods lists have
* tuples are immutable lists
''')

t0 = (1,2)
t1 = (3,4)
t_concatenation = t0 + t1
t_repetition = t0 * 2
t_index = t_concatenation[0]
t_slice = t_concatenation[0:3]
t_x2 = [x ** 2 for x in t_concatenation]
t_int = (70)
t_tuble_int = (70, )

print(t0)
print(t1)
print('concatenation: {}'.format(t_concatenation))
print('repetition: {}'.format(t_repetition))
print('index: {}'.format(t_index))
print('slice: {}'.format(t_slice))
for iterate in t_concatenation:
    print(iterate)
print(t_x2)
print(t_int)
print(t_tuble_int)

t_unsorted = (800, 7, 25, 1, 0)
t_unsorted_list = list(t_unsorted)
print(t_unsorted_list)
t_unsorted_list.sort()  # sort the list
print(t_unsorted_list)

T = (2, 2, 3, 3)
print(T.count(3))
