import 'dart:async';
import 'dart:convert';
import 'dart:io';
import 'dart:math';

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

// lists and collections
lists() {
  var list = [1, 2, 3];
  print('list: ${list[0]}');

  var l = [
    0,
    ...[1, 2, 3]
  ];
  print("list: ${l[3]}");

  var filtered = list.where((element) => element > 1).toList();
  print('filtered: $filtered');

  var mapped = [1, 2].map((e) => e * 2);
  print('mapped: $mapped');

  var items = List.generate(3, (index) => index * 10);
  print('generated list: $items');
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

///
/// Stream: A source of asynchronous data events.
/// https://api.dart.dev/stable/2.8.4/dart-async/Stream-class.html
streams() async {
  var s = Stream<int>.periodic(Duration(seconds: 1), (value) {
    return value;
  });

  await for (int i in s) {
    print('streams: $i');
    if (i == 1) break;
  }

  print('### read file from 2 to 6 characters ###');
  Stream<List<int>> file = File('README.md').openRead(2, 6);
  file.transform(utf8.decoder).listen((event) {
    print('file content: $event');
  }).onDone(() {
    print('file processed.');
  });
  print('### content of file will be print out after this ###');

  // https://dart.dev/articles/libraries/creating-streams
  Stream<int> giveRandomNumbers(int max) {
    Timer timer;
    StreamController<int> controller;
    int counter = 0;

    // parameter Timer isnt used => _
    void tick(_) {
      counter++;
      controller.add(Random().nextInt(100));
      if (counter == max) {
        timer.cancel();
        controller.close();
      }
    }

    void start() {
      timer = Timer.periodic(Duration(seconds: 1), tick);
    }

    // reference function (start, ...) after declaration
    controller = StreamController<int>(
      onListen: start,
    );

    return controller.stream;
  }

  giveRandomNumbers(3).listen((event) {
    print('RANDOM: $event');
  });
}

///
/// An object representing a delayed computation.
/// https://api.dart.dev/stable/2.8.4/dart-async/Future-class.html
future() async {
  Future<int> _request() async {
    var s = 2;
    await Future.delayed(Duration(seconds: s));
    return s;
  }

  int i = await _request();
  print('future: $i');

  Future<String> greetingOfTheDay() =>
      Future.delayed(Duration(seconds: 3), () => 'hello world');

  // option 0:
  var greeting = greetingOfTheDay();
  greeting.then((value) => print('greeting of the day: $value'));

  // option 1: we can use await in a async function
  print(await greeting);

  var numbers = List.empty(growable: true);
  await Future.forEach([
    10,
    20,
    30,
  ], (element) => numbers.add(element));
  print('item count: ${numbers.length}');
}

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

optionalRequired({bool debug, String message}) {}

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

microtask() {
  Future.microtask(() =>
      Future.delayed(Duration(seconds: 2)).then((value) => print('task 0')));
  Future.microtask(() =>
      Future.delayed(Duration(seconds: 1)).then((value) => print('task 1')));
  Future.microtask(() =>
      Future.delayed(Duration(seconds: 4)).then((value) => print('task 2')));
}

zones() {
  runZoned(() {});
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
  future();

  named(true, "message");
  optional();
  optional(message: "message");
  json();

  microtask();
}
