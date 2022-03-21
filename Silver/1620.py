import sys

n, m = map(int, sys.stdin.readline().split())

pokemon = []
pokemon_dic = {}

for i in range(n):
    temp = input().rstrip()
    pokemon.append(temp)
    pokemon_dic[temp] = i + 1

for _ in range(m):

    temp = input().rstrip()

    if temp.isdigit():
        print(pokemon[int(temp)-1])
    else:
        print(pokemon_dic[temp])
