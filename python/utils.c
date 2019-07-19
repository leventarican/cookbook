#include <stdio.h>

/*
cc -fPIC -shared -o libutils.so utils.c
*/

int square(int x) {
  return x * x;
}

long benchmark() {
  int result = 0;
  for (int i = 1; i < 10000001; ++i) {
    result++;
    result = (result * result) % 3;
  }
  return result;
}
