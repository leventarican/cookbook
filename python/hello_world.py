print('hello world')

a = [4, 9, 1]
print("a is a pointer to object list")
print(type(a))

b = a
print("(pointer) b show also to object ")
a.append(7)

print(b)

print(id("a"))  # memoty location
