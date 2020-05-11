# https://introcs.cs.princeton.edu/python/12types/

type_int = 99
type_float = 3.14
type_complex = complex(1, 2)
type_bool = True
type_str = 'python'

# numeric types
print(f'int literal: {type(type_int)}')
print(f'float literal: {type(type_float)}')

print(f"complex: {type(type_complex)}")
print(type_complex)
print(type_complex.real)
print(type_complex.imag)

print(f'int operator power: {2**2}')
print(f'float operator exponentation: {1.1**2}')

print(f'bool literal: {type_bool}')
print(f'str literal: {type_str}')
print(f'bool operator and: {True or False}')