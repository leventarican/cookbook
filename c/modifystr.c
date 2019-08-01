#include <stdio.h>
#include <string.h>

int replace0(char * str) {
  str[1] = '.';
  printf("%s\n", str);

  return 0;
}

int replace1(char * str) {
  int len = strlen(str);
  for (int i = 0; i < len; i++) {
    if (str[i] == ',') {
      str[i] = '.';
    }
  }
  printf("%s\n", str);

  return 0;
}

int main(int argc, char const *argv[]) {

  char pi[] = "3,14";
  replace0(pi);

  return 0;
}
