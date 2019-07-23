#include <stdio.h>

int main(int argc, char const *argv[]) {

  double mathconst[2];
  mathconst[0] = 3.14;
  mathconst[1] = 2.17;
  printf("%0.2lf\n", mathconst[0]);

  int fibbonaci[] = {0, 1, 1, 2, 3, 5, 8};
  for (int i = 0; i < 7; i++) {
    printf("%d ", fibbonaci[i]);
  }
  printf("\n");

  return 0;
}
