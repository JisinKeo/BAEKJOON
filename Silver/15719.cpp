#include <iostream>
using namespace std;

int main() {
    cin.tie(0); #c++에서 실행속도를 빠르게 해주는 코드
    ios_base::sync_with_stdio(0); #c++에서 실행속도를 빠르게 해주는 코드
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
