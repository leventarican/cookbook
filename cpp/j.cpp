#include <iostream>
using namespace std;

// vector / array

int main() {
    char a[] = "java";
    cout << a << " = " << &a[0]<< endl;

    char* b = "c++";
    cout << b << " = " << &b[0]<< endl;

    int c[] = {1, 20, 300};
    cout << "address: " << (void*) c << endl;
    cout << "address: " << &c[0] << endl;
    cout << "address: " << (int*) c << endl;

    const char* d = "python";
    cout << d << endl;
}
