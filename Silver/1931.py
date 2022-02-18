testcase = int(input())
inputs = []
for i in range(testcase):
    a, b = map(int, input().split())
    inputs.append((a,b))

cnt = 0
time = 0
inputs.sort(key=lambda x: (x[1] ,x[0]))

for a, b in inputs:
    if a>=time:
        cnt += 1
        time = b

print(cnt)
