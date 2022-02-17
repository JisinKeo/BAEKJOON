k, n = map(int, input().split())
rope = []
for i in range(k):
    ropes = int(input())
    rope.append(ropes)
small = 1
large = max(rope)+1
while small <= large:
    mid = (small+large) // 2
    su = 0
    for i in range(k):
        su += (rope[i]//mid)
    
    if su<n:
        large = mid-1
    else:
        small = mid+1
    
print(small-1)
