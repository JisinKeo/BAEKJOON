test = int(input())

def DFS(a,b):
    global array
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    if a<0 or a>=m or b<0 or b>=n:
        return
    if array[a][b] == 0:
        return
    array[a][b] = 0
    for i in range(4):
        DFS(a+dx[i], b+dy[i])
        
        
for i in range(test):
    m, n, k = map(int, input().split())
    array = [[0 for col in range(n)] for row in range(m)]
    
    cnt = 0
    for j in range(k):
        x, y = map(int, input().split())
        array[x][y] = 1

    for a in range(m):
        for b in range(n):
            if array[a][b]==1:
                DFS(a,b)
                cnt+=1

    print(cnt)
            
    
    
