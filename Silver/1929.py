m, n = map(int, input().split())

check = [0] * 1000001

for i in range(2, n+1):
    if check[i] == 0:
        if i>=m:
            print(i)
        for j in range(i, n+1, i):
            check[j] = 1
