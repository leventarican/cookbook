#include <stdio.h>

int main() {

  printf("%s\n", "integer: ");

  // 8 bit
  signed char sc = 0;
  unsigned char uc = 0;
  printf("%d bytes\n", sizeof(sc));
  printf("%d bytes\n", sizeof(uc));

  // 16 bit
  short s = 0;
  unsigned short us = 0;
  printf("%d bytes\n", sizeof(s));
  printf("%d bytes\n", sizeof(us));

  // 32 bit
  long l = 0;
  unsigned long ul = 0;
  printf("%d bytes\n", sizeof(l));
  printf("%d bytes\n", sizeof(ul));

  // 64 bit
  long long ll = 0;
  unsigned long long ull = 0;
  printf("%d bytes\n", sizeof(ll));
  printf("%d bytes\n", sizeof(ull));

  // Word size
  int i = 0;
  unsigned int ui = 0;
  printf("%d bytes\n", sizeof(i));
  printf("%d bytes\n", sizeof(ui));

  // integer:
  // 1 bytes
  // 1 bytes
  // 2 bytes
  // 2 bytes
  // 8 bytes
  // 8 bytes
  // 8 bytes
  // 8 bytes
  // 4 bytes
  // 4 bytes

  printf("%s\n", "floating point: ");
  float f = 0;
  double d = 0;
  long double ld = 0;

  printf("single precision %d bytes\n", sizeof(f));
  printf("double precision %d bytes\n", sizeof(d));
  printf("other precision %d bytes\n", sizeof(ld));

  // floating point:
  // single precision 4 bytes
  // double precision 8 bytes
  // other precision 16 bytes
}
