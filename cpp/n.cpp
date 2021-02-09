#include <iostream>

using namespace std;

// static belongs to the type not instance. we dont need to create an instance.
// so no instance is required for a static member
// static can be: field, method, class, constructor, properties, operator, ...
// static is memory efficient

class request {
    public:
        string payload;
        static int version;
        request(string payload) {
            this->payload = payload;
        }
        void display() {
            cout << "payload: " << payload << "; version: " << version << endl;
        }
};

int request::version = 100;

int main() {
    std::cout << "static" << std::endl;

    string payload = "load data";
    request r = request(payload);
    r.display();

    return 0;
}