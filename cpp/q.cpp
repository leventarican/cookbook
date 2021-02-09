#include <iostream>

// |stream | description                      |
// |-------|----------------------------------|
// |cin    | standard input stream            |
// |cout   | standard output stream           |
// |cerr   | standard error (output) stream   |
// |clog   | standard logging (output) stream |

int main() {
    int input;
    std::cin >> input;

    std::cout << "cin\t- input stream\n'>>'\t- extraction operator\nvalue\t- variable (destination)" << std::endl;

    std::cout << "cout\t- output stream\n'<<'\t- insertion operator" << std::endl;
}