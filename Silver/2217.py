n = int(input())
rope = []
for i in range(n):
    k = int(input())
    rope.append(k)
rope.sort(reverse=True)
rope_max = rope[0]
for i in range(1,n):
    cache = rope[i]*(i+1)
    rope_max = max(rope_max, cache)

print(rope_max)
