def BFS(x,y,check):
    global zero, one
    
    if n<2:
        return

    temp = paper[x][y]
    cache = 0
    for i in range(x,x+check):
        for j in range(y, y+check):
            if temp != paper[i][j]:
                cache = 1
                break
    if cache == 0:
        if temp == 0:
            zero += 1
        elif temp == 1:
            one += 1
        return
    else:
        for i in range(0, int(check), check//2):
            for j in range(0, int(check), check//2):
                BFS(x+i, y+j, check//2)        


if __name__ == "__main__":

    n = int(input())
    paper = [list(map(int, input().split())) for _ in range(n)]
    two = n // 2
    check = n
    zero, one = 0, 0

    temp = paper[0][0]
    flag = 0
    for i in range(n):
        for j in range(n):
            if temp != paper[i][j]:
                flag = 1
    if flag == 0:
        if temp == 0:
            print(1)
            print(0)
        else:
            print(0)
            print(1)
    else:
        for i in range(2):
            for j in range(2):
                BFS(two*i, two*j, check//2)
        print(zero)
        print(one)
