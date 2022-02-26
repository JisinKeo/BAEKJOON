n, c = map(int, input().split())

house = []

for _ in range(n):
    temp = int(input())
    house.append(temp)
house.sort()
left = 1
right = max(house)

while left<=right:
    mid = (left+right) // 2
    ep = min(house)
    cnt = 1
    for i in range(n):
        if ep+mid <= house[i]:
            ep = house[i]
            cnt += 1
    if cnt<c:
        right = mid - 1
    else:
        left = mid + 1
print(right)


