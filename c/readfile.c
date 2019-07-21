#include <stdio.h>

int read() {
  FILE *fp;
  fp = fopen("file", "r");

  if (fp == NULL) {
    printf("%s\n", "error");
    return 1;
  }

  double mathconst[2];
  fscanf(fp, "%lf", &mathconst[0]);
  fscanf(fp, "%lf", &mathconst[1]);

  printf("%0.2lf\n", mathconst[0]);
  printf("%0.2lf\n", mathconst[1]);

  fclose(fp);
}

int main(int argc, char const *argv[]) {
  read();

  return 0;
}
