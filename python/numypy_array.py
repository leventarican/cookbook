import numpy as np

apythonlist = [ [25, 24, 26], [23, -2, 3], [0, 1, 2] ]
anumpyarray = np.array(apythonlist)
amatrix2d = np.matrix( ' 1 2 3; -1 0 1; 1 1 4 ' )

print('\na python list:')
print(apythonlist)
print(type(apythonlist))

print('\na numpy array:')
print(anumpyarray)
print(type(anumpyarray))

print('\na matrix always 2d. a subclass of numpy.array:')
print(amatrix2d)
print(type(amatrix2d))
