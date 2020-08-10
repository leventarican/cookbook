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
      var randomNumber = Random().nextInt(100);
      controller.add(randomNumber);
      // controller.sink.add(randomNumber);
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

  Stream<String> dataGenerator() {
    StreamController<String> controller;

    void start() {
      for (var i = 0; i < 3; i++) {
        controller.sink.add('# data: $i');
      }
    }

    void stop() {
      controller.close();
    }

    controller = StreamController<String>(
        onListen: start, onCancel: stop, onPause: stop, onResume: start);
    return controller.stream;
  }

  dataGenerator().listen((event) {
    print(event);
  });

  // example with syntax sugar async* and yield
  // async* will return a stream whereas async will return Future
  // with async* we can also yield a value
  Stream<int> countStream(int to) async* {
    for (int i = 1; i <= to; i++) {
      yield i;
    }
  }
  countStream(3).listen((event) {
    print('# count stream: $event');
  });
  countStream(1).expand((element) => {2, 3}).skip(1).listen((event) {
    print('# count stream [expand, skip]: $event');
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
  }, zoneValues: {0: 'dart', 1: 'flutter'});
}

main(List<String> args) {
  streams();
  future();
  microtask();
  zones();
}
