from collections import deque

def travel():
    queue = deque([1])
    visited[1] = True
    while queue:
        now = queue.popleft()
        for move in range(1,7):
            check_move = now+move
            if 0 < check_move <= 100 and not visited[check_move]:
                if check_move in ladder.keys():
                    check_move = ladder[check_move]

                if check_move in snack.keys():
                    check_move = snack[check_move]

                if not visited[check_move]:
                    queue.append(check_move)
                    visited[check_move] = True
                    cnt[check_move] = cnt[now] + 1
                    if check_move == 100:
                        return



if __name__ == '__main__':
    n, m = map(int,input().split())
    cnt = [0] * 101
    visited = [False] * 101

    snack = {}
    ladder = {}
    for _ in range(n):
        x, y = map(int,input().split())
        ladder[x] = y
    for _ in range(m):
        u, v = map(int,input().split())
        snack[u] = v

    travel()
    print(cnt[100])
