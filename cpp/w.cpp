// #include <iostream>
#include <bits/stdc++.h>

using namespace std;

// RUN WITH:
// g++ -std=c++11 -O2 -Wall w.cpp -o app && ./app

void code0() {
	int a, b;
	string x;

	cin >> a >> b >> x;
}

void code1() {
	string s;
	getline(cin, s);

	cout << "in: " << s << "\n";
}

// long long 64bit
void code2() {
	long long x = 123456789123456789LL;
	cout << x << endl;
}

// floating point double: 64bit
// long double: 80bit (more precise)
// Note that while floating point numbers are inaccurate
void code3() {
	double x = 0.3 * 3 + 0.1;
	printf("%.20f\n", x);
}

// set theory
// a set is a collection of elements
void code4() {
	// x = {2, 3, 7}
}

// overflow
void code5() {
	unsigned int x = 3 - 10;
	cout << x << endl;
}

void code6() {
	int a[2];
	cout << a << endl;

	int b[3] = {100, 200, 300};
	// time comlexity: O(3)
	for (int i = 0; i <= 2; i++) {
		// when i <= 3 then "segmentation fault (core dumped)"
		cout << b[i] << endl;
	}
}

void code7() {
	int d[2][2] = {
		{10, 20},
		{30, 40}
	};
	// time comlexity: O(2^2)
	for (int i = 0; i <= 1; i++) {
		for (int j = 0; j <= 1; j++) {
			cout << d[i][j] << endl;
		}
	}
}

void code8() {
	vector<int> v = {4,2,5,3,5,8,3};
	sort(v.begin(),v.end());

	for (vector<int>::const_iterator i = v.begian(); i != v.end(); ++i)
		cout << *i << ' ';
}

void code9() {
	// int = 32bit
	// 00000000000000000000000000101011

	// TODO: mask, shift, ...
}

void code10() {
	char vek[] = "nutshell";
	cout << "vek=" << vek << endl;
	cout << "vek[0]=" << vek[0] << endl;
	cout << "&vek[0]=" << &vek[0] << endl;
	cout << "&vek=" << &vek << endl;
	cout << "*vek=" << *vek << endl;
	cout << "(void *)vek=" << (void *)vek << endl;
}

int main() {
	cout << "ready.\n";

	// code0();
	// code1();
	// code2();
	// code3();
	// code5();
	// code6();
	// code7();
	// code8();
	// code9();
	code10();
}
