testcase = int(input())

for i in range(testcase):
    n, m = map(int,input().split())
    
    fish_A = list(map(int,input().split()))
    fish_B = list(map(int,input().split()))
    fish_A.sort()
    fish_B.sort()
    cnt = 0
    for i in range(n):

        left = 0
        right = len(fish_B)-1
        while left <= right :
            mid = (left + right) // 2
            if fish_B[mid] < fish_A[i]:
                left = mid+1
            else:
                right = mid - 1
        cnt += left
    print(cnt)  
