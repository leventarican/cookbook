#include <iostream>
#include <vector>

using namespace std;

int positive_sum(const std::vector<int> arr) {
	printf("%li\n", arr.size());
	
	for (int i = 0; i < arr.size(); i++) {
		printf("%d\n", arr[i]);
	}

	return 0;
}

int main() {
	cout << "c++ language\n";

	positive_sum( vector <int> {1,2,3,4,5} );

	return 0;
}
