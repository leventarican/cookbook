import 'dart:convert';
import 'dart:math';
import 'dart:io';

mixin Color {
  String _rgba = '0x00112200';

  console() {
    print('RGBA: ${int.parse(_rgba, radix: 16)}');
  }
}

///
/// with mixin (Color)
class Point with Color {
  num x, y;
  Point({this.x = 0, this.y = 0});

  // named constructor
  Point.random(this.x, int seed)
      : assert(seed > 5 && seed < 10),
        y = Random().nextInt(seed);

  Point.fromJson(Map json)
      : x = json['x'],
        y = json['y'];

  void add() {
    this.x += 1;
    this.y += 1;
  }

  void sub() {
    this.x -= 1;
    this.y -= 1;
  }

  consoleOut() {
    print('${toString()}');
  }

  static String get whoami => 'a point';

  @override
  String toString() => 'Colored Point: $x, $y, $_rgba';
}

classes() {
  Point p = new Point();
  print(p);
  print(new Point(x: 3, y: 2));
  print(new Point(y: 1));

  // invoke add / sub methods but return reference to object (builder pattern)
  p
    ..add()
    ..sub()
    ..add()
    ..add();
  print("method cascade: $p");

  Point()
    ..x = 10
    ..y = 20
    ..consoleOut()
    ..x = 100
    ..consoleOut()
    ..y = 200
    ..consoleOut();

  Point ppp = Point.random(7, 9);
  print('point with named constructor: $ppp');

  print('whoami: ${Point.whoami}');

  var json = Point.fromJson({'x': 1000, 'y': 2000});
  print('with JSON constructed Point : $json');
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

if_and_else() {
  if (false) {
    print('if');
  } else if (false) {
    print('else if');
  } else {
    print('else');
  }
}

///
/// run with: dart --enable-asserts
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

Iterable<int> count(max) sync* {
  var i = 0;
  while (i < max) {
    yield i++;
    sleep(Duration(seconds: 1));
  }
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

///
/// https://dart.dev/guides/language/language-tour#optional-parameters
named(bool debug, String message) {
  if (debug) {
    print('debug: $message');
  } else {
    print('$message');
  }
}

optional({String message}) {
  print('message: $message');
}

///
/// To use the @required annotation,
/// depend on the meta package and import package:meta/meta.dart.
///
// optionalRequired({ @required bool debug, String message}) {}

positionalParameters(String prefix, [String suffix]) {
  print('$prefix.$suffix');
}

json() {
  dynamic data = '''
  [
    {
      "lang": "java",
      "version": 11
    },
    {
      "lang": "dart",
      "version": 2.9
    }
  ]
  ''';
  var languages = jsonDecode(data);
  print('dart version: ${languages[1]['version']}');
  print(languages);

  data = [
    {'lang': 'cpp', 'version': 17},
    {'lang': 'python', 'version': 3.8},
  ];
  var json = jsonEncode(data);
  print(json);
}

hashtagline() {
  List.generate(80, (index) {
    stdout.write('#');
    if (index == 79) {
      stdout.write('\n');
    }
  }, growable: false);
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
  print('a function with one expression: ${digit()}');
  first_class();
  classes();
  if_and_else();
  switch_case();
  bitwise_shift();

  print("foobar".ping());
  safe();
  execution_control_with_assert();

  named(true, "message");
  optional();
  optional(message: "message");
  positionalParameters("file");
  positionalParameters("file", "txt");
  json();

  count(3).forEach((element) {
    print('sync* $element');
  });
}
