#include <iostream>

using namespace std;

int main() {
    int numbers[] = {2, 4, 6};
    cout << "expected=4; actual=" << *(numbers+1) << endl;
}
