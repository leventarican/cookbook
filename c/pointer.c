#include <stdio.h>

int main(int argc, char const *argv[]) {
    int a[2] = {10, 20}, *b, c;

    printf("adress: %p\n", a);
    printf("adress: %p\n", b);
    printf("adress: %p\n", &c);

    b = a;
    printf("adress: %p\n", b);
    b = b + 1;
    printf("adress (int size = 4 byte): %p\n", b);
    printf("value in index 1: %d\n", *b);
}