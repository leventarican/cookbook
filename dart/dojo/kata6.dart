// https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/train/dart

//              1
//           3     5
//        7     9    11
//    13    15    17    19
// 21    23    25    27    29
// ...

int rowSumOddNumbers(int n) {
  var gaussiansum =
      List.generate(n, (i) => ++i).reduce((value, element) => value + element);
  var solution = List.generate(gaussiansum, (index) => index + index + 1)
      .reversed
      .take(n)
      .reduce((value, element) => value + element);
  print(solution);
  return solution;
}

// int rowSumOddNumbers(int n) => n * n * n;

main(List<String> args) {
  assert(rowSumOddNumbers(2) == 8);
  assert(rowSumOddNumbers(3) == 27);
  assert(rowSumOddNumbers(42) == 74088);
}
