# import statement example
import example_module
print(example_module.s)
example_module.foo(example_module.a)

# from statement example
# from <module_name> import <name(s)>
from example_module import s, a, foo
print(s)
foo(a)
