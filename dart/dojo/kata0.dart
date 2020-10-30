// https://www.codewars.com/kata/514b92a657cdc65150000006/dart

// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
// The sum of these multiples is 23.

// Finish the solution so that it returns the sum of all the multiples of 3 or 5
// below the number passed in.

// Note: If the number is a multiple of both 3 and 5, only count it once.
// Also, if a number is negative, return 0(for languages that do have them)

// #############################################################################
// multiplies of 3 or 5

// ex. first 20 multiplies 
// Multiples of 1: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 
// Multiples of 3: 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60 
// Multiples of 5: 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100 

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
