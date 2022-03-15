import sys

n, m = map(int,input().split())

number = list(map(int,sys.stdin.readline().split()))

result = [0]*n
result[0] = number[0]
for i in range(1, n):
    result[i] = result[i-1] + number[i]

for i in range(m):
    start, end = map(int,sys.stdin.readline().split())
    if start==1:
        temp = result[end-1]
    else:
        temp = result[end-1] - result[start-2]

    print(temp)
