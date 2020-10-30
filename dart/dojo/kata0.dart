// https://www.codewars.com/kata/514b92a657cdc65150000006/dart

// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
// The sum of these multiples is 23.

// Finish the solution so that it returns the sum of all the multiples of 3 or 5
// below the number passed in.

// Note: If the number is a multiple of both 3 and 5, only count it once.
// Also, if a number is negative, return 0(for languages that do have them)

// #############################################################################
// multiplies of 3 or 5

int solution(int n) {

  // special requirements
  if (n <= 3) {
    return 0;
  }

  // for 10: 3, 6, 9
  var three = [for (var i = 3; i < n; i+=3) i];
  // for 10: 5
  var five = [for (var i = 5; i < n; i+=5) i];
  var solution = three.toSet().union(five.toSet()).reduce((a, b) => a+b);

  print(solution);
  return solution;
}

main(List<String> args) {
  // int actual = 10; // exp = 23
  // int actual = 20;  // exp = 78
  int actual = 200;  // exp = 9168

  solution(actual);

}
