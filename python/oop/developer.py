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

java = Developer(0, 'java')
py = Developer(1, 'py')
java.code()
py.code()

kotlin = LeadDeveloper(0, 'kotlin')
kotlin.code()
