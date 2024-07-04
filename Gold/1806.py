import sys

N, S = map(int, sys.stdin.readline().split())

number = list(map(int, sys.stdin.readline().split()))

start, end = 0, 0
current_sum = 0
min_length = float('inf')

while end < N:

    current_sum += number[end]
    end += 1

    while current_sum >= S:
        min_length = min(min_length, end - start)
        current_sum -= number[start]
        start += 1

if min_length == float('inf'):
    min_length = 0
    
print(min_length)

