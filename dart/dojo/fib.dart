main(List<String> args) {

  // fibbonaci: sum of predessors; except first two numbers
  int fib(int i) {
    if (i < 2) return i;
    return fib(i-1) + fib(i-2);
  }

  assert(fib(5) == 5);
  assert(fib(2) == 1);
  assert(fib(6) == 8);
}
