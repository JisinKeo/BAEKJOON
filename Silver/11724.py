import sys



n, m = map(int, sys.stdin.readline().split())

graph = [[] for i in range(n+1)]

for i in range(0,m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (n+1)

def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

result = 0

for i in range(1,n+1):
    if visited[i] == 0:
        dfs(graph, i, visited)
        result += 1
        

sys.stdout.write(str(result))
