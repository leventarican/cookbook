#include <iostream>
#include <string>

// commmand line args
// strings

int main(int argc, char* argv[]) {
    std::cout << argv[0] << std::endl;

    std::string line (80,'#');
    std::string a = "code in c++";
    const char* b = "code in cpp";
    std::string c("C-String example");

    std::cout << line << std::endl;

    if (a == b) {
        std::cout << "a == b" << std::endl;
    } else {
        std::cout << "a != b" << std::endl;
    }
    std::cout << "a: " << a << "; b: " << b << "; c: " << c << std::endl;

    std::string d(a, 8, 3);
    std::cout << "string, start, number of characters - d: " << d << std::endl;

    std::string e(a.begin(), a.end() - 7);
    std::cout << "e: " << e << std::endl;

    for (int pos = 0; pos < e.length(); ++pos )
    	std::cout << e.at(pos) << "_";
    std::cout << std::endl;

    return 0;
}
