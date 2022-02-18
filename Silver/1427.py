num = input()
result = []
for i in range(len(num)):
    result.append(int(num[i]))
result.sort(reverse=True)
results = 0
for i in range(len(num)):
    results += result[i]
    if i < len(num)-1:
        results *= 10
print(results)
