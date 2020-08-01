#include <stdio.h>

int main(int argc, char const *argv[]) {

  int exp = 20;

  printf("if short-cut: %s\n", (exp > 5 ? "senior" : "junior") );

  if (exp < 5) {
    printf("%s\n", "junior");
  }

  if (exp > 5) {
    printf("%s\n", "senior");
  } else {
    printf("%s\n", "junior");
  }

  if (exp > 5) {
    printf("%s\n", "senior");
  } else if (exp > 10) {
    printf("%s\n", "expert");
  } else {
    printf("%s\n", "junior");
  }

  switch(exp) {
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
      printf("switch: %s\n", "junior");
    default:
      printf("switch: %s\n", "senior");
  }

  for (int i = 0; i < 10; i++) {
    exp++;
  }
  printf("exp: %d\n", exp);

  do {
    printf("%s\n", "expert");
  } while(exp > 30);

  while (exp > 30) {
    printf("%s\n", "expert");
  }

  // comma operator
  int a, b;
  for(a=1, b=10; a<b; a++, b--) {
    printf("%d - %d\t", a, b);
  }

  return 0;
}
