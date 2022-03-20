string = input()

string = string.split('-')
cache = []
for i in range(len(string)):
    temp = string[i].split('+')
    temp_sum = 0
    for j in range(len(temp)):
        temp_sum += int(temp[j])

    cache.append(temp_sum)
total = cache[0]
for i in range(1, len(cache)):
    total -= cache[i]

print(total)

