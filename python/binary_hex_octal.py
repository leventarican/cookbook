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
