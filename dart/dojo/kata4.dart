// https://www.codewars.com/kata/5a63948acadebff56f000018/train/dart

import 'dart:math';

int maxProduct(List<int> arr, int size) {
  arr.sort((int a, int b) => (a > b)? -1 : 1);
  // arr.sort((int a, int b) => a.compareTo(b) -1);
  print(arr);
  // arr.remove(arr.reduce(min));
  var solution = arr.takeWhile((_) => size-- > 0).reduce((int a, int b) => a*b);
  print(solution);
  return solution;
}

// arr.sort((a, b) => b.compareTo(a));
// return arr.take(size).reduce((a, b) => a * b);

main(List<String> args) {
  assert(maxProduct([8, 10 , 9, 7], 3) == 720);
  // explanation: Since the size (k) equal 3,
  // then the subsequence of size 3 whose gives product of maxima is 8 * 9 * 10 = 720.

  // maxProduct([8, 10 , 9, 7], 3);
}
