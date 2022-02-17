testcase = int(input())

for i in range(testcase):
    length, ant = map(int, input().split())
    ma_a = 0
    ma_b = 0
    for j in range(ant):
        number = int(input())
        if number<length-number:
            a = number
            b = length-number
        elif number>=length-number:
            a = length-number
            b = number
        if ma_a < a:
            ma_a = a
        if ma_b < b:
            ma_b = b
    print(ma_a, ma_b)
    
