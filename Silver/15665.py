from itertools import product

n, m = map(int,input().split())

sequence = list(map(int, input().split()))
sequences = []
for i in product(sequence, repeat=m):
    sequences.append(i)
sequences.sort()

sequences = set(sequences)
combi = list(sequences)
combi.sort()
for i in range(len(combi)):
    for j in range(m):
        print(combi[i][j], end=' ')
    print()
