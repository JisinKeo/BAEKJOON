a, b = map(int, input().split())

k = 1
l = 0
sumre = 0
sumree = 0 
for i in range(b):
    
    sumre += k
    l += 1
    if l == k:
        l = 0
        k += 1

k = 1
l = 0
for i in range(a-1):
    
    sumree += k
    l += 1
    if l == k:
        l = 0
        k += 1
print(sumre-sumree)
