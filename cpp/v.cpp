#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
#include <limits>

using namespace std;

class Atom {
private:
    int a;
public:
	Atom() {}
	~Atom() {}
    Atom(int i) {a = i;}
    void print();
};

class Water : public Atom {
public:
	void print() { cout << "Water::print()" << endl; }
    void pack() {

    }
};

void Atom::print() { cout << "Atom::print()" << endl; }

int main() {
    Atom a;
    a.print();

    Atom *p = &a;
    p->print();

    Atom *c = new Atom();
    c->print();

    Water *w = new Water();
    w->print();

    int vek[] = {5, 3, 8, 3, 6, 2, 8, 4, 2, 2};
    // 8,2,8,2
    // 5,3,3,6,2,4,2
    cout << vek[1] << endl;

    int sum = 0;

    for(int i=0; i<10; i++) {
        cout << vek[i] << endl;
        sum += vek[i];
    }

    cout << sum << endl;
    int amount = sum / 20;
    cout << amount << endl;
}