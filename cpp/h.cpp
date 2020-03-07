#include <iostream>

// a global function declaration
void showVersion();

// a global function does not belong to a class or namespace
void showVersion() {
    std::cout << "version 17";
}

int main() {
    // a statement (end with semicolon)
    int version = 17;
    std::cout << "c++ " << version;
    
    // a set of statements [anweisung]
    {
        version++;
        version--;
    }
    
    // (arithmetic) expression [ausdruck]: version - 4
    version = version - 4;
    
    showVersion();
    
    return 0;
}
