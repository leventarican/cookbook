# https://github.com/tonybaloney/wily-pycharm
# https://plugins.jetbrains.com/plugin/14424-wily/versions/stable
#
class Developer:
    def __init__(self, id, programminglang):
        self.id = id
        self.programminglang = programminglang

    def code(self):
        print('dev: {} is coding {}'.format(self.id, self.programminglang))


'''
inheritance
'''
class LeadDeveloper(Developer):
    def __init__(self, id, programminglang):
        self.id = id
        self.programminglang = programminglang

    def code(self):
        print(f'lead dev: {self.id} is coding {self.programminglang}')


if __name__ == '__main__':
    print("hello from pycharm")

    for x in range(0, 10):
        print(x)

    password = "secret"
    if password == "secret":
        print("grant access")

    # kotlin = Developer(0, 'kotlin')
    # python = Developer(1, 'python')
    #
    # kotlin.code()
    # python.code()
