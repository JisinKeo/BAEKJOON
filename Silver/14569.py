n = int(input())
lecture = []
for i in range(n):
    lecture .append(list(map(int,input().split())))

check = [0] * 51

m = int(input())
for i in range(m):
    cnt = 0
    student = (list(map(int,input().split())))
    for j in range(1, student[0]+1):
        check[student[j]] = 1
    for i in range(n):
        temp = 1
        for j in range(1, lecture[i][0]+1):
            if check[lecture[i][j]] == 0:
                temp = 0
        if temp == 1:
            cnt += 1
    
    check = [0] * 51
    print(cnt)
