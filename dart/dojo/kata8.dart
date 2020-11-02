// https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/dart

List<String> wave(String str) {
  List<String> solution = [];
  for (var i = 0; i < str.length; i++) {
    var a = str.substring(0, i);
    var b = new String.fromCharCode(str.runes.elementAt(i)).toUpperCase();
    var c = str.substring(i + 1);
    solution.add(a + b + c);
  }
  while (solution.remove(str)) {}
  print(solution);
  return solution;
}

// List<String> anotherSolution(String str) {
//   return List.filled(str.length, str)
//       .asMap()
//       .entries
//       .where((e) => e.value[e.key] != " ")
//       .map((e) =>
//           e.value.replaceRange(e.key, e.key + 1, e.value[e.key].toUpperCase()))
//       .toList();
// }

main(List<String> args) {
  wave("hello");
  // wave(" gab ");
}
