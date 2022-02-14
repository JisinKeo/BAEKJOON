#include<iostream>

using namespace std;

int main() {

	long long x, y, z;

	cin >> x >> y;

	z = (y * 100) / x;
	if (z >= 99) {
		cout << -1;
		return 0;
	}
	long long a, b, c, z_temp;
	a = 0;
	b = 1000000000;

	while (a <= b) {
		c = (a + b) / 2;
		z_temp = ((y + c) * 100) / (x + c);
		if (z_temp > z) {
			b = c - 1;
		}
		else if(z_temp == z) {
			a = c + 1;
		}
	}
	cout << a;
	return 0;
}
