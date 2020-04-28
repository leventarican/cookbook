
class Point {
    num x, y;
    Point(this.x, this.y);
}

classes() {
    var p = new Point(3, 2);
    print('p: ${p.x}');
}

first_class() {
    void printElement(int element) {
        print('function as parameter: $element');
    }
    var l = [3, 1, 4];
    l.forEach(printElement);

    var f = (x) => x*2;
    print('assign a function to a variable ${f(1)}');

    l.forEach((item) => print('anonymous function: $item'));
}

int digit() => 1;

maps() {
    var programming = {
        100: 'java',
        200: 'go',
        300: 'dart',
        400: 'kotlin'
    };

    print('programming: ${programming[100]}');

    var languages = Map();
    languages[10] = 'c++';
    languages[20] = 'c';
    languages[30] = 'python';

    print('languages: ${languages[20]}');
}

lists() {
    var list = [1, 2, 3];
    print('list: ${list[0]}');
}

basic() {
    var declaration;
    var i = 1;
    print('declaration and initialization - i: $i');

    var raw_string = r'print every character:\t\n. also escape chars.';
    print(raw_string);

    print('default values are always null (they are objects): $declaration');

    num n;
    print('num class: int or floating number: $n');
}

// omitting type void does work
main() {
    String welcome = 
    '''
in dart everthing is an object.
all object inherits from class.

function are first-class objects.
you can pass a function as a parameter to another function.
    ''';
    print(welcome);

    basic();
    lists();
    maps();
    print('a function with one expression: ${digit()}');
    first_class();
    classes();
}