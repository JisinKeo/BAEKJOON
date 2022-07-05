#include <iostream>
using namespace std;

int main() {
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    int n;
    
    int sum = 0;
    
    cin >> n;
    for (int i = 0; i < n; i++){
        sum += i;
        int x;
        cin >> x;
        sum -= x;
    }
    cout << -sum;
}
