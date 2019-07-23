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

int readcsv() {
  FILE* stream = fopen("/home/dev/root/cookbook/python/100000salesrecords.csv", "r");
  char line[1024];
  int line_count = 0;
  while (fgets(line, 1024, stream)) {
    line_count++;
  }
  return line_count;
}
