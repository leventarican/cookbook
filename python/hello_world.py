print('hello world')

a = [4, 9, 1]
print("a is a pointer to object list")
print(type(a))

b = a
print("(pointer) b show also to object ")
a.append(7)

print(b)

print(id("a"))  # memoty location

# integers
i = 7
exponent = i ** 2
u = 5_000_000
x,y = 3,4
print(exponent)
print(x)
print(y)

# floats
f = i + 0.14
print(f)
print(f**2)

numbers = range(15)
print(','.join(str(number) for number in numbers))
