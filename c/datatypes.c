#include <stdio.h>

// maximum programming language
#define MAX_PL 3

/* a developer has a level: ex. 0 to 100 and know PL (max. 3) */
struct developer {
  unsigned short level;
  char programming_languages[MAX_PL][16];
};

int main() {
  printf("%s\n", "integer: ");

  // 8 bit
  signed char sc = 0;
  unsigned char uc = 0;
  printf("%d bytes\n", (int) sizeof(sc));
  printf("%d bytes\n", (int) sizeof(uc));

  // 16 bit
  short s = 0;
  unsigned short us = 0;
  printf("%d bytes\n", (int) sizeof(s));
  printf("%d bytes\n", (int) sizeof(us));

  // 32 bit
  long l = 0;
  unsigned long ul = 0;
  printf("%d bytes\n", (int) sizeof(l));
  printf("%d bytes\n", (int) sizeof(ul));

  // 64 bit
  long long ll = 0;
  unsigned long long ull = 0;
  printf("%d bytes\n", (int) sizeof(ll));
  printf("%d bytes\n", (int) sizeof(ull));

  // Word size
  int i = 0;
  unsigned int ui = 0;
  printf("%d bytes\n", (int) sizeof(i));
  printf("%d bytes\n", (int) sizeof(ui));

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

  printf("single precision %d bytes\n", (int) sizeof(f));
  printf("double precision %d bytes\n", (int) sizeof(d));
  printf("other precision %d bytes\n", (int) sizeof(ld));

  // floating point:
  // single precision 4 bytes
  // double precision 8 bytes
  // other precision 16 bytes

  struct developer foo;
  
  foo.level = 50;
  foo.programming_languages[0][0] = 'J';
  foo.programming_languages[0][1] = 'a';
  foo.programming_languages[0][2] = 'v';
  foo.programming_languages[0][3] = 'a';
  foo.programming_languages[0][4] = '\0';
  foo.programming_languages[1][0] = 'C';
  foo.programming_languages[1][1] = '\0';
  foo.programming_languages[2][0] = 'G';
  foo.programming_languages[2][1] = 'o';
  foo.programming_languages[2][2] = '\0';

  printf("level: %i; prog. lang.: %s, %s, %s\n", foo.level, foo.programming_languages[0], foo.programming_languages[1], foo.programming_languages[2]);
}

