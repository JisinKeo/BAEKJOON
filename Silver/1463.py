n = int(input())

count = [0] * (n+1)

count[1] = 0

for i in range(2, n+1):
    count[i] = count[i-1] + 1
    if i % 3 == 0:
        temp = count[i//3] + 1
        count[i] = min(temp,count[i])
    if i % 2 == 0:
        temp = count[i//2] + 1
        count[i] = min(temp,count[i])
print(count[n])

