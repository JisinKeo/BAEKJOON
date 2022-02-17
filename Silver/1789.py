#수들의 합

n = int(input())
result = 0
i = 1
while(True):
    if(result>n):
        print(i-2)
        break
    result += i
    i += 1
