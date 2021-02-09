#include <iostream>

using namespace std;

int main() {
    int a = 1;
    int& b = a;
    int* c = &a;

    cout << "\nvariable binding: a = " << a;
    cout << "\ntype reference to int: b = " << b;
    cout << "\npointer to int: c = " << c;
    c = &b;
    cout << "\npointer to int: c = " << c;

    a = 1000;
    cout << "\nvariable binding: a = " << a;
    cout << "\ntype reference to int: b = " << b;
    cout << "\npointer to int: c = " << c;
}