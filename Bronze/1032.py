def listToString(str_list):
    result = ""
    for s in str_list:
        result += s
    return result.strip()

n = int(input())


file = []
result = []
for i in range(0,n):
    stri = input()
    file.append(stri)

for i in range(len(file[0])):
    cache = file[0][i]
    count = 0
    for j in range(n):
        if cache != file[j][i]:
           result.append('?')
           count = 1
           break
    if count == 0:
        result.append(cache)

resultt = listToString(result)

print(resultt)
