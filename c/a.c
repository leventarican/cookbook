#include <stdio.h>

/*
Die Programmiersprache C. RRZN 12. Auflage April 2001
*/

// structured types
struct StructExample {
    int i;
    float f;
    double d;
};

union UnionExample {
    short s;
    int i;
};

// enum
enum Logtypes { DEBUG, INFO, WARN, ERROR };

int main(int argc, char const *argv[]) {
    printf("%s\n", "c works.");

    // declaration
    int i;
    // definition (now memory is allocated)
    i = 12;

    printf("%d\n", i);
    printf("sizeof (byte): %d\n", sizeof(i));

    // enum usage
    enum Logtypes log;
    log = DEBUG;    // equals 0
    if (log == 0) {
        printf("DEBUG %s\n", "works");
    }

    // array also called vector
    int vek[3];
    vek[0] = 12;
    vek[1] = 23;
    vek[2] = 34;
    printf("%d\n", *vek);

    // struct usage
    struct StructExample s;
    s.i = 42;
    printf("struct example: %d\n", s.i);

    // union usage
    union UnionExample u;
    u.i = 42;
    u.s = 24;
    printf("union example: %d\n", u.i);

    // qualifiers

    // const
    const double pi = 3.14;
    printf("%f\n", pi);

    // volatile
    // - for hardware interrupts
    // - no compiler code optimizations
    volatile int v = 1;

    // static
    static const double f = 1.23;
    printf("%f\n", f);

    return 0;
}
