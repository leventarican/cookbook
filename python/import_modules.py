# we have build in functions
print('for sure this one is build in')
print( 'python chars [use of str and len functions]: ' + str(len('python')) )

# now lets extend our vocabulary; like random, sys, os and math
import random   # import module called random
a_random_number = random.randint(0,9)
print(a_random_number)

# another option
from math import *
print(pi)

# import a function
from math import cos
print(cos(1))

# or just improt module path from os and use alias
from os import path as ospath
print(ospath.abspath('.'))

# or import __our__ function
import functions
functions.printPI()
