#include<iostream>
using namespace std;

int main() {
	int num;
	cin >> num;
	int two = 0;
	int five = 0;
	if (num == 0 || num == 1) {
		cout << 0;
		return 0;
	}
	for (int i = 2; i < num + 1; i++) {
		int cache = i;
		
			while (cache % 2 == 0 || cache % 5 == 0) {
				if (cache % 2 == 0) {
					cache = cache / 2;
					two++;
				}
				if (cache % 5 == 0) {
					cache = cache / 5;
					five++;
				}
			}
		

		
	}
	if (two > five) {
		cout << five;
	}
	else {
		cout << two;
	}
	return 0;
}
