import numpy as np

print('''
NumPy: numerical python
#######################
''')

def example_0():
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

def example_1():
    a = np.array(
        [1,2,3]
    )
    b = np.array(
        [
            [1,2],
            [0,0]
        ]
    )
    c = np.array(
        [
            np.arange(1000)
        ]
    )
    d = np.array(
        [
            [1,2,3],
            [4,5,6],
            []
        ]
    )
    print(a)
    print(a.shape)

    print('###')

    print(b)
    print(b.shape)

    print('###')

    # print(c)
    print(c.shape)

    print('###')

    print(d.shape)
    print( d[1] )
    print( a[0] )

    print('###')

def example_2():
    nhwc = np.array([
        [
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]]
        ],
        [
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]], 
            [[1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ], [1, 2, 3 ]]
        ]
    ])
    print(nhwc.shape)
    # (2, 6, 6, 3)

    hwc = nhwc[0]
    print(hwc.shape)
    # (6, 6, 3)
    
    pixel_blue_channel = hwc[3][3][2]
    print(pixel_blue_channel)
    # 3

def example_3():
    a = np.random.rand(2, 4)
    print( a )
    print( a.shape )
    print( a[0].ndim )
    # [[0.79847456 0.96754259 0.60703037 0.42084671]
    # [0.68036863 0.488115   0.46423815 0.69767461]]
    # (2, 4)
    # 1

    b = a.reshape(4, 2)
    print( b.shape )
    print( b )
    # (4, 2)
    # [[0.79847456 0.96754259]
    # [0.60703037 0.42084671]
    # [0.68036863 0.488115  ]
    # [0.46423815 0.69767461]]

def example_4():
    a = np.array([
        [
            []
        ]
    ])
    print( a.ndim )
    print( a.shape )
    # 3
    # (1, 1, 0)

    b = np.array([1,2,3 ])
    print( b.ndim )
    print( b.shape )
    # 1
    # (3,)

    c = np.array([
        [],
        [],
        []
    ])
    print( c.ndim )
    print( c.shape )
    # 2
    # (3, 0)

# example_0()
# example_1()
# example_2()
# example_3()
example_4()
