#include <bits/stdc++.h>

using namespace std;

// alias / shortcut
typedef long long ll;

int main() {
    int type32bit = 200;
    cout << type32bit << "\n";
    
    string x = "c++17";
    cout << x << "\n";
    
    long long type64bit = 123456789123456789LL;
    ll c = 1LL;
    // \n is faster then endl. that flushes operation.
    cout << "ll: " << type64bit << "\n";
    cout << "ll: " << c << "\n";
    
    vector<int> v;
    for (int i=0; i<10; i++) {
        v.push_back(i);
    }
    cout << "vector v: " << v.at(7) << "\n";
    cout << "vector v: " << v[4] << "\n";
    
    int r[] = {7,4,3,1};
    for (int i=0; i<4; i++) {
        cout << r[i];
    }
    cout << "\n";
    
}
