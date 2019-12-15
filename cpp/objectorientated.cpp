#include "objectorientated.h"
#include <iostream>

/**
 * compile: g++ objectorientated.cpp
 * run: ./a.out
 */
int main() {
	ObjectOrientated a;
	a.init();
	a.display();
	std::cout << a.p << std::endl;
	
	ObjectOrientated *b;
	b = &a;
	
	b->display();
	std::cout << b->p << std::endl;
	
	return 0;
}

void ObjectOrientated::init() {
	a = 1;
	c = 90;
	x = 3.14;
	
	p = 2;
}

void ObjectOrientated::display() {
	std::cout << a << '\n' << c << '\n' << x << std::endl;
}