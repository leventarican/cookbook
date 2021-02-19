#include <iostream>
#include <algorithm>
#include <cmath>

// https://stackoverflow.com/a/7627330
// []() { } // barebone lambda

int main() {
    int a = 100;
    std::cout << a << std::endl;

    auto l = [a]()  { return a + 1; };
    auto b = l();
    std::cout << b << std::endl;
}

// 100
// 101
