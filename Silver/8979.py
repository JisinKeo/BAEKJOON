n, k = map(int, input().split())


medal = []

for i in range(n):
    a = list(map(int,input().split()))
    medal.append(a)


rank = [1] * n

for i in range(n):
    for j in range(n):
        if medal[i][1]<medal[j][1]:
            rank[i] = rank[i] + 1
        elif (medal[i][1] == medal[j][1]) and (i!=j):
            if (medal[i][2]<medal[j][2]):
                rank[i] = rank[i] + 1
            elif (medal[i][2] == medal[j][2]) and (i!=j):
                if (medal[i][3]<medal[j][3]):
                    rank[i] = rank[i] + 1

for i in range(n):
    if medal[i][0] == k:
        print(rank[i])
        break
