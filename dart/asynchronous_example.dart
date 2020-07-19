import 'dart:convert';
import 'dart:io';
import 'dart:async';

import 'dart:math';

import 'main.dart';

///
/// Stream: A source of asynchronous data events.
/// https://api.dart.dev/stable/2.8.4/dart-async/Stream-class.html
streams() async {
  hashtagline();

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
  hashtagline();
  
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

microtask() {
  hashtagline();
  Future.microtask(() =>
      Future.delayed(Duration(seconds: 2)).then((value) => print('task 0')));
  Future.microtask(() =>
      Future.delayed(Duration(seconds: 1)).then((value) => print('task 1')));
  Future.microtask(() =>
      Future.delayed(Duration(seconds: 4)).then((value) => print('task 2')));
}

///
/// A zone represents an environment that remains stable across asynchronous calls.
/// https://api.flutter.dev/flutter/dart-async/Zone-class.html
/// 
zones() {
  hashtagline();

  // Instance of '_RootZone'
  print('current zone (=main): ${Zone.current}');

  runZoned(() {
    print('current zone: ${Zone.current}; value: ${Zone.current[0]}');
  }, zoneValues: {0:'dart', 1:'flutter'});
}

main(List<String> args) {
  streams();
  future();
  microtask();
  zones();
}