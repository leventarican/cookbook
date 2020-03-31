import numpy as np

print('NumPy: numerical python')

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

print('\narange: returns a 1d ndarray(n-dimension array) with a range of sequential numeric values')
print(f'upper bound: {np.arange(3)}')
print(f'lower and upper bound: {np.arange(3, 6)}')
print(f'reversed with list slicing: {np.arange(3, 6)[::-1]}')
print(f'steps: {np.arange(start=0, stop=30, step=10)}')

print('\nndarray attributes')
nums = np.arange(12)
print(f'nums: {nums}')
print(f'shape (tuble with dimension of array): {nums.shape}')
print(f'number of dimension: {nums.ndim}')
print(f'number of elements: {nums.size}')
print(f'reshape 1d to 2d: {nums.reshape(2,6).ndim}')
print(f'reshape 1d to 3d:\n {nums.reshape(2,3,2)}')