# 예외처리가 핵심이다.......

import sys
from collections import deque

T = int(input())
for i in range(T):
    p = sys.stdin.readline().rstrip()
    n = int(input())
    arr = deque(sys.stdin.readline().rstrip()[1:-1].split(","))
    temp = len(arr)
    count = 0
    flag = 0
    if n == 0 and len(arr)==1:
        for i in range(len(p)):
            if p[i] == 'D':
                
                print('error')
                flag = 1
                break
    if flag == 0:
        for j in range(len(p)):
                if len(arr)==0 and p[j] =='D':
                    print('error')
                    flag = 1
                    break
                if p[j]=='R':
                    count += 1
                    
                elif p[j]=='D':
                    if count == 0:
                        arr.popleft()
                        
                    elif count % 2 == 1:
                        arr.pop()
                    else:
                        arr.popleft()
        
        if temp>0 and flag == 0:
            if count % 2 == 1:
                arr.reverse()
            print("["+",".join(arr)+"]")
    


