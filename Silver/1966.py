from collections import deque
test = int(input())
for i in range(test):
    n, k = map(int, input().split())

    dq = [(a, b) for a, b in enumerate(list(map(int, input().split())))]
    dq = deque(dq)
    cnt = 0
    while True:
        cur = dq.popleft()
        if any(cur[1]<x[1] for x in dq):
            dq.append(cur)
        else:
            cnt += 1
            if cur[0]==k:
                print(cnt)
                break
