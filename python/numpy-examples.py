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

print('\n# arange: returns a 1d ndarray(n-dimension array) with a range of sequential numeric values')
print(f'upper bound: {np.arange(3)}')
print(f'lower and upper bound: {np.arange(3, 6)}')
print(f'reversed with list slicing: {np.arange(3, 6)[::-1]}')
print(f'steps: {np.arange(start=0, stop=30, step=10)}')

print('\n# ndarray attributes')
nums = np.arange(10)
print(f'nums: {nums}')
print(f'shape (tuble with dimension of array): {nums.shape}')
print(f'number of dimension: {nums.ndim}')
print(f'number of elements: {nums.size}')
print(f'reshape 1d to 2d (2x5=10): {nums.reshape(2,5).ndim}')
print(f'reshape 1d to 3d (1x5x2=10):\n {nums.reshape(1,5,2)}')

print('\n# random numbers')
print(f'random (0-2): {np.random.randint(3)}')
print(f'random (0-2): {np.random.randint(3)}')
print(f'random (1-2): {np.random.randint(1,3)}')

print('\n# random numbers')
print(f'random 1x2 1d array: {np.random.randn(2)}')
print(f'random 3x3x3 3d array:\n {np.random.randn(3, 3, 3)}')