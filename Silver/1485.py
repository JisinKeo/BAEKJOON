import math

n = int(input())

for i in range(n):
    point = [list(map(int, input().split())) for _ in range(4)]
    distance = []
    for j in range(4):
        for k in range(j+1, 4):
            temp = pow(pow(point[j][0]-point[k][0],2)+pow(point[j][1]-point[k][1],2),0.5)
            distance.append(temp)

    distance.sort()
    if distance[0]==distance[1] and distance[1]==distance[3] and distance[4]==distance[5]:
        print("1")
    else:
        print("0")
