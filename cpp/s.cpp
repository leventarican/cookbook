#include <iostream>

using namespace std;

// new and delete operators
// Dynamic Memory Allocation
// segmentation fault demo
// c: malloc() or calloc(), free()

// https://www.javatpoint.com/cpp-memory-management

int main() {
    float* p;
    p = new float(3.14);
    cout << "\nnew example: " << *p;

    int size = 8;
    int* a = new int[size];
    cout << "\narray: " << *a;
    *a = 100;
    *a++;
    *a = 200;
    *a--;
    cout << "\narray: " << *a;
    cout << "\narray: " << a[1] << endl;

    delete [] a;
    cout << "\nprocessing finished: " << a[0] << endl;

    cout << "\nprocessing finished: " << endl;
    cout << "\nsegmentation fault: " << a[100] << endl;
}