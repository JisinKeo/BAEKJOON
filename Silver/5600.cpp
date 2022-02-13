#include<iostream>
using namespace std;

int main() {
	int a, b, c;

	cin >> a >> b >> c;

	int n;

	cin >> n;
	int p, q;
	int i[1001], j[1001], k[1001], r[1001];
	int ui = a + b + c;
	int result[301] = { 2, };
	int e;
	for (e = 0; e < 301; e++) {
		result[e] = 2;
	}
	int check[301] = { 0, };
	for (p = 0; p < n; p++) {
		cin >> i[p] >> j[p] >> k[p] >> r[p];
		if (r[p] == 1) {
			check[i[p]] = 1;
			check[j[p]] = 1;
			check[k[p]] = 1;
		}
	}
	for (p = 0; p < n; p++) {		
		if (r[p] == 0) {
			if (check[i[p]] == 1 && check[j[p]] == 1 && check[k[p]] == 0) {
				result[k[p]] = 0;
			}
			else if (check[i[p]] == 1 && check[j[p]] == 0 && check[k[p]] == 1) {
				result[j[p]] = 0;
			}
			else if (check[i[p]] == 0 && check[j[p]] == 1 && check[k[p]] == 1) {
				result[i[p]] = 0;
			}
		}
		else if (r[p] == 1) {
			result[i[p]] = 1;
			result[j[p]] = 1;
			result[k[p]] = 1;
			for (q = 0; q < n; q++) {
				if (r[q] == 0) {
					if (i[p] == i[q] && j[p] == j[q] && k[p] != k[q]) {
					
							result[k[q]] = 0;
						
					}
					if (i[p] == i[q] && j[p] != j[q] && k[p] == k[q]) {
						
							result[j[q]] = 0;
					
					}
					if (i[p] != i[q] && j[p] == j[q] && k[p] == k[q]) {
					
							result[i[q]] = 0;
						
					}
				}
			}
		}
	}

	for (p = 1; p < ui + 1; p++) {
		cout << result[p] << "\n";
	}

	return 0;
}
