#include <stdio.h>
#include <math.h>

/* compile with: gcc functions.c -lm */
/* https://en.wikipedia.org/wiki/Sigmoid_function */
double sigmoid_function(double x) {
  printf("%f\n", M_E);
  printf("%f\n", expf(1.0));
  return exp(x) / (exp(x) + 1.0);
}

/* we dont have the option to return two values. instead we use pointers. */
void modify_value(int *a, int *b) {
  printf("a: %d; b: %d\n", *a, *b);
  *a = *a * 100;
  *b = *b * 100;
}

int main(int argc, char const *argv[]) {
  double x = 0.0, result;
  result = sigmoid_function(x);
  printf("sigmoid_function of %.2lf: %.2lf\n", x, result);

  int a = 1;
  int b = 2;
  modify_value(&a, &b);
  printf("a: %d; b: %d\n", a, b);

  return 0;
}
