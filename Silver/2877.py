n = int(input())
check = 2
checks = 2
temp = []

if n==1:
    print(4)
elif n==2:
    print(7)
else:
    while True:
        if n<=check:
            while True:
                if n % 2 == 0:
                    temp.append(7)
                else:
                    temp.append(4)
                if n % 2 == 0:
                    n -= 1
                n = n // 2
                if n == 1:
                    temp.append(4)
                    break
                elif n == 2:
                    temp.append(7)
                    break
        if n<3:
            break
        checks *= 2
        check = check + checks
result = 0
for i in range(len(temp)-1, -1, -1):
    print(temp[i], end='')
