#include <iostream>
using namespace std;

// prototype
void manipulate(int&);
void trytoman(const int&);
void nexttry(int&);

int main() {
	int a = 1;
	cout << "a=" << a << endl;
	manipulate(a);
	cout << "a=" << a << endl;

	int b = 2;
	cout << "b=" << b << endl;
	trytoman(b);
	cout << "b=" << b << endl;

	int i(3);
	nexttry(i);
	cout << "i=" << i << endl;
	nexttry(i = 4);
	cout << "i=" << i << endl;
	nexttry(++i);
	cout << "i=" << i << endl;

	return 0;
}

void nexttry(int& n) {
	++n;
}

void manipulate(int& r) {
	r = 7;
}

void trytoman(const int& c) {
	//c = 8;
}
