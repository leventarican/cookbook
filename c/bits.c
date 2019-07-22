#include <stdio.h>

int main(int argc, char const *argv[]) {
  unsigned char bit0, bit1;

  bit0 = 1; // 0000 0001
  bit1 = 2; // 0000 0010

  printf("%d: 0000 0000\n", bit0 & bit1);
  printf("%d: 0000 0011\n", bit0 | bit1);
  printf("%d: 0000 0010\n", bit0 << 1);
  printf("%d: 0000 0001\n", bit0 >> 1);

  return 0;
}
