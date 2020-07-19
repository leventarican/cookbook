import 'main.dart';

lists() {
  hashtagline();

  var list = [1, 2, 3];
  print('a list: $list');

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

sets() {
  hashtagline();

  var example = {1, 1, 2, 3};
  print('a set: $example');
}

maps() {
  hashtagline();

  var programming = {100: 'java', 200: 'go', 300: 'dart', 400: 'kotlin'};
  print('a map: $programming');

  print('programming: ${programming[100]}');

  var languages = Map();
  languages[10] = 'c++';
  languages[20] = 'c';
  languages[30] = 'python';

  print('languages: ${languages[20]}');
}



///
/// https://dart.dev/codelabs/iterables#what-are-collections
/// https://dart.dev/guides/language/language-tour#lists
///
main(List<String> args) {
  print('''
  Iterable collections: list, set, map
  ''');

  lists();
  sets();
  maps();
}
