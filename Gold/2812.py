num, m = map(int,input().split())
n = int(input())
n = list(map(int, str(n)))
stack = []

cnt = 0

for x in n:
    while m>0 and stack and stack[-1]<x:
        stack.pop()
        m -= 1
    stack.append(x)

while m>0:
    stack.pop()
    m -= 1
for i in stack:
    print(i, end='')
