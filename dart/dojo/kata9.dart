// https://www.codewars.com/kata/559e3224324a2b6e66000046/train/dart

// 1 <= x <= n, 1 <= y <= n

int sumin(int n) {
  var sum = 0;
  for (var x = 1; x <= n; x++) {
    for (var y = 1; y <= n; y++) {
      sum += x < y ? x : y;
    }
  }
  print(sum);
  return sum;
}

int sumax(int n) {
  var sum = 0;
  for (var x = 1; x <= n; x++) {
    for (var y = 1; y <= n; y++) {
      sum += x > y ? x : y;
    }
  }
  print(sum);
  return sum;
}

int sumsum(int n) {
  var a = sumin(n) + sumax(n);
  print(a);
  return a;
}

// int sumin(int n) => n * (n + 1) * (2 * n + 1) ~/ 6;
// int sumax(int n) => n * (n + 1) * (4 * n - 1) ~/ 6;
// int sumsum(int n) => n * n * (n + 1);

main(List<String> args) {
  assert(sumin(5) == 55);
  // assert(sumax(8) == 372);
  // assert(sumsum(8) == 576);
}
