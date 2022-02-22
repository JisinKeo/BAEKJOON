import sys
import math
n = int(input())

alpha = []
for i in range(n): 
    alpha.append(sys.stdin.readline().rstrip())
max_alpha = 0
for i in range(n):
    for j in range(len(alpha[i])):
        if max_alpha < ord(alpha[i][j])-65:
            max_alpha = ord(alpha[i][j])-65

         
count = [0] * (max_alpha+1)
for i in range(n):
    digit = pow(10,(len(alpha[i])-1))
    digit = int(digit)
    for j in range(len(alpha[i])):
        count[ord(alpha[i][j])-65] += digit
        digit /= 10
cnt_alpha = 0        
for i in range(len(count)):
    if count[i] > 0:
        cnt_alpha += 1
check = 9
counts = [0] * (max_alpha+1)
for i in range(cnt_alpha):
    temp = 0
    idx = 0 
    for j in range(len(count)):
        if temp < count[j]:
            temp = count[j]
            idx = j
    counts[idx]=check
    check -= 1
    count[idx] = -1
     
result = []
for i in range(n):
    cache = 0
    for j in range(len(alpha[i])):
        temps = counts[ord(alpha[i][j])-65]
        cache += temps
        if j < len(alpha[i])-1:
            cache *= 10
    result.append(cache)
results = 0
for i in range(len(result)):
    results += int(result[i])

print(results)
