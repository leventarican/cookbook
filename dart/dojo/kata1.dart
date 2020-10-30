// https://www.codewars.com/kata/525e5a1cb735154b320002c8/train/dart

// triangular numbers := equilateral triangular shape

// triangular(0)==0,
// triangular(2)==3,
// triangular(3)==6,
// triangular(-10)==0

// return nth triangular number
triangular(n) {
  // ex. 2:
  // **
  // *
  var sum = 0;
  for (var i = n; i > 0; i--) {
    print("*"*i);
    sum += i;
  }
  return sum;
}

// triangular(n) => n < 0 ? 0 : (n+1)/2 * n;

main(List<String> args) {
  // assert(triangular(2)==3);
  triangular(0);
  triangular(2);
  triangular(3);
  triangular(-10);
}