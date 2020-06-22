import 'dart:math';

class Point {
  num x, y;
  Point({this.x = 0, this.y = 0});
  // named constructor
  Point.random(this.x, int seed)
      : assert(seed > 5 && seed < 10),
        y = Random().nextInt(seed);

  void add() {
    this.x += 1;
    this.y += 1;
  }

  void sub() {
    this.x -= 1;
    this.y -= 1;
  }

  @override
  String toString() => 'Point: $x, $y';
}

classes() {
  Point p = new Point();
  print(p);
  print(new Point(x: 3, y: 2));
  print(new Point(y: 1));

  p
    ..add()
    ..sub()
    ..add()
    ..add();
  print("method cascade: $p");

  Point pp = new Point()
    ..x = 10
    ..y = 20;
  print("point: $pp");

  Point ppp = Point.random(7, 9);
  print('point with named constructor: $ppp');
}

first_class() {
  void printElement(int element) {
    print('function as parameter: $element');
  }

  var l = [3, 1, 4];
  l.forEach(printElement);

  var f = (x) => x * 2;
  print('assign a function to a variable ${f(1)}');

  l.forEach((item) => print('anonymous function: $item'));
}

int digit() => 1;

maps() {
  var programming = {100: 'java', 200: 'go', 300: 'dart', 400: 'kotlin'};

  print('programming: ${programming[100]}');

  var languages = Map();
  languages[10] = 'c++';
  languages[20] = 'c';
  languages[30] = 'python';

  print('languages: ${languages[20]}');
}

if_and_else() {
  if (false) {
    print('if');
  } else if (false) {
    print('else if');
  } else {
    print('else');
  }
}

// run with: dart --enable-asserts
execution_control_with_assert() {
  try {
    var i = 100;
    assert(i < 100, 'foobar');
    print('assert: ${i * 2}');
  } catch (e) {
    print('exception should be AssertionError: ${e.runtimeType}.');
  }
}

switch_case() {
  switch (1) {
    case 0:
      print('0');
      break;
    case 1:
      print('1');
      break;
    default:
      print('default');
  }
}

lists() {
  var list = [1, 2, 3];
  print('list: ${list[0]}');

  var l = [
    0,
    ...[1, 2, 3]
  ];
  print("list: ${l[3]}");
}

dynamic basic() {
  var declaration;
  var i = 1;
  print('declaration and initialization - i: $i');

  var raw_string = r'print every character:\t\n. also escape chars.';
  print(raw_string);

  print('default values are always null (they are objects): $declaration');

  num n;
  print('num class: int or floating number: $n');

  String s = 'dart';
  print("type String: $s");

  dynamic d = 'flutter';
  d = 100;
  print("dynamic: $d");
}

// bitwise: & | ^
// bitwise complement: ~
// shift
bitwise_shift() {
  final value = 0xFF;
  final bitmask = 0x0F;

  // and
  print(value & bitmask);

  // or
  print(value | bitmask);

  // not
  print(~value);

  // shift right
  print(value >> 4);
}

// extension methods
extension Ping on String {
  String ping() {
    return "$this pong";
  }
}

safe() {
  var n = null;
  var v = n ?? "n was null";
  print(v);

  var p = new Point();
  p?.add();
  print(p);

  Point d = null;
  d?.add();
  print(d);
}

streams() async {
  var s = Stream<int>.periodic(Duration(seconds: 1), (value) {
    return value;
  });

  await for (int i in s) {
    print(i);
  }
}

// omitting type void does work
main() {
  String welcome = '''
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
  if_and_else();
  switch_case();
  bitwise_shift();

  print("foobar".ping());
  safe();
  execution_control_with_assert();

  streams();
}
