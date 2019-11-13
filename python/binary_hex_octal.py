print(
    '''
    literals: hex, octal, binary
    integers can be coded in hexdecimal, octal an binary notation
    binary base: 2
    hex base: 16
    otcal base: 7
    '''
)

binary = 0b_0000_0100_0110_1110
print(binary)

hex = 0x046E
print(hex)

octal = 0o2156
print(octal)

converted_bin = bin(1134)
print('convert int (1234) to binary as string: {}'.format(converted_bin))

# ##############################################################################
# bit manipulation: https://wiki.python.org/moin/BitManipulation

bit_value = '0b00000010'
int_value = int(bit_value, base=2)
print(f'bit value: {bit_value}; int value: {int_value}')
print(str(0b00000010))

# ##############################################################################
# bitwise operations

a = 0b0000_0010
b = 0b0000_0010
print(f'AND: {bin(a and b)}')
print(f'OR: {bin(a or b)}')
print(f'XOR: {bin(a ^ b)}')
print(f'NOT: {bin(~a)}')
