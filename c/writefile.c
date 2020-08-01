#include <stdio.h>

int write() {
  FILE *fp;
  fp = fopen("file", "w");

  if (fp == NULL) {
    printf("%s\n", "error");
    return 1;
  }

  double mathconst[] = {3.14, 2.17};
  fprintf(fp, "%1.2f\n", mathconst[0]);
  fprintf(fp, "%1.2f\n", mathconst[1]);

  fclose(fp);
}

int main(int argc, char const *argv[]) {
  write();
  
  return 0;
}
