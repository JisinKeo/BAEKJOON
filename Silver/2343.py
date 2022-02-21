import sys
#sys.stdin = open("input.txt", "rt")

n, m = map(int,input().split())
dvd = list(map(int,input().split()))

left = max(dvd)
right = sum(dvd)

while left <= right:
    mid = (left+right)//2
    sum_dvd = 0
    cnt = 0
    for i in range(n):
        sum_dvd += dvd[i]
        if sum_dvd > mid:
            sum_dvd = dvd[i]
            cnt+=1
    
    if cnt < m:
        right = mid - 1
    elif cnt >= m:
        left = mid + 1
print(left)    
