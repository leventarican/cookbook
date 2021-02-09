#include <iostream>
#include <cmath> // or math.h

using namespace std;

// basic class / object / instance examples
// classes and structs are blueprints that are used to create the instance of a class

class code {
    public:
        int id;
        string programming_language;
        void display() {
            cout << this->id << "; " << this->programming_language << endl;
        }
};

class dummy {};
class foobar;

class construct {
    public:
        construct() {
            cout << "default constructor | invoked automatically" << endl;
        }
        ~construct() {
            cout << "destructor | invoked automatically" << endl;
        }
};

class developer {
    public:
        static developer* instance() {
            if(!m_instance)
                m_instance = new developer();
            return m_instance;
        }
        static int version;
    private:
        developer();
        developer(developer const&);
        static developer* m_instance;
};

// struct is a value type | class is a reference type
struct point {
    double x;
    double y;
};

// use only one field a or b
union data {
    short a;
    int b;
};

int developer::version = 100;

int main() {
    code c;
    c.id = 0;
    c.programming_language = "java";
    c.display();

    dummy d;
    cout << &d << endl;

    construct e;

    // developer::instance();
    

    struct point a;
    struct point b;
    a.x = 0;
    a.y = 0;
    b.x = 10;
    b.y = 10;
    double distance = sqrt((b.x - a.x) * (b.x - a.x) + (b.y - b.y) * (b.y - b.y));
    cout << "distance: " << distance << endl;

    union data u;
    u.a = 1;
    u.b = 2;
    cout << "union example (a is overwritten!): " << u.a << endl;

    cout << "last statement: cleanup, deconstructor, ..." << endl;

    return 0;
}
