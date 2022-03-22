import sys

def BFS(x,y,check):
    global minus, zero, one
    if check < 1:
        return
    check = int(check)
    temp = paper[x][y]
    cache = 0
    for i in range(int(check)):
        for j in range(int(check)):
            if temp != paper[x+i][y+j]:
                cache = 1
                break
    if cache == 0:
        if temp == -1:
            minus += 1
        elif temp == 0:
            zero += 1
        else:
            one += 1
        return
    else:
        for i in range(0, int(check), check//3):
            for j in range(0, int(check), check//3):
                BFS(x+i,y+j,check//3)
    
    
if __name__ == "__main__":

    n = int(input())
    minus, zero, one = 0, 0, 0
    paper = [list(map(int, input().split())) for _ in range(n)]
    cache = paper[0][0]
    plan = 0
    for i in range(n):
        for j in range(n):
            if cache != paper[i][j]:
                plan = 1
                break
    if plan == 0:
        if cache == -1:
            minus +=1
        elif cache == 0:
            zero += 1
        else:
            one += 1

        print(minus)
        print(zero)
        print(one)
        sys.exit(0)
    check = n
    three = n // 3
    three = int(three)
    for i in range(3):
        for j in range(3):
            BFS(three*i, three*j, check//3)

    print(minus)
    print(zero)
    print(one)
    
