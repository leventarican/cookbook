# https://introcs.cs.princeton.edu/python/43stack/

# queue: known as first-in-first-out or FIFO
# stack: last-in-first-out (LIFO)

# init: when create a stack then init an emtpy array
# push: an element 
# pop: an element
class Stack:
    def __init__(self):
        self.stack = []
    def push(self, element):
        self.stack += [element]
    def pop(self):
        self.stack.pop()
    def toString(self):
        s = ''
        for element in self.stack:
            s = str(element) + ' ' + s
        return s

if __name__ == "__main__":
    stack = Stack()
    stack.push(3)
    stack.push(9)
    stack.pop()
    print(stack.toString())
