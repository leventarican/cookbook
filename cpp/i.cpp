#include <iostream>
using namespace std;

// g++ i.cpp && ./a.out
// g++ -std=c++11 i.cpp && ./a.out

// nullptr since c++11
// https://manderc.com/types/nullpointer/index.php

class ProgrammingLanguage {
    public:
        string id;
        string getId() {
            return id;
        }
};

void code(ProgrammingLanguage* lang) {
    cout << "# programming in: " << lang << endl;
}

void code(string lang) {
    cout << "## programming in: " << lang << endl;
}

int main() {
    // what do you think which of the overloaded function is called?
    code(nullptr);
}
