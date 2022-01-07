import sys

n = int(sys.stdin.readline())
if n==1 or n==3 :
    print(-1)
else:  
    cnt=0
    while n%5!=0:
        n = n - 2
        cnt = cnt+1

    if n!=0:
        p = n // 5
        cnt = cnt+p

    print(cnt)

