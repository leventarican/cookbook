#include <iostream>

using namespace std;

// pointer improves performance
// access any memory location 

int main() {
    int* a;

    // segmentation fault
    // cout << "a pointer to int: " << a << endl;

    // allocate memory
    int* b = new int(1);

    a = b;
    cout << "a pointer to int: " << *a << "value of a: " << a << endl;

    int c = 2;
    a = &c;
    cout << "assign address of c to a: " << *a << endl;

    cout << "address of a: " << a << "; address of c" << &c << endl;

    cout << "address of main function: " << &main << endl;

    return 0;
}
