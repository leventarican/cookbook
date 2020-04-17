# https://introcs.cs.princeton.edu/python/43stack/

# queue: known as first-in-first-out or FIFO
# stack: last-in-first-out (LIFO)

# init: when create a stack then init an emtpy array
# push: an element 
# pop: an element
class Stack:
    def __init__(self):
        self.a = []
    def push(self, element):
        self.a += [element]
    def pop(self):
        self.a.pop()
    def toString(self):
        s = ''
        for element in self.a:
            s = str(element) + ' ' + s
        return s

class Queue(Stack):
    def pop(self):
        self.a = self.a[::-1]
        self.a.pop()

if __name__ == "__main__":
    print('# Stack')
    stack = Stack()
    stack.push(3)
    stack.push(9)
    print(stack.toString())
    print('now last out: pop')
    stack.pop()
    print(stack.toString())

    print('\n# Queue')
    queue = Queue()
    queue.push(3)
    queue.push(9)
    print(queue.toString())
    print('now first out: pop')
    queue.pop()
    print(queue.toString())
