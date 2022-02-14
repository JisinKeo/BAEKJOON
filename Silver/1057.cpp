#include<iostream>

using namespace std;

int main() {

	int n, a, b;
	cin >> n >> a >> b;
	int count = 1;
	while(n){
		a = (a+1)/2;
		b = (b+1)/2;
		
		if(a == b){
			cout << count;
			return 0;
		}
		
		n = n/2;
		count++;
	}
	if(n>0){
		cout << -1;
		return 0;
	}
	return 0;
}
