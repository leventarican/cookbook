#include <stdio.h>

int main(int argc, char const *argv[]) {

  int exp = 20;

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

  return 0;
}
