zero_one = input()
check = 2
zero_cnt = 0
one_cnt = 0

if zero_one[0] == '0':
    zero_cnt += 1
elif zero_one[0] == '1':
    one_cnt += 1
for i in range(len(zero_one)):
    if zero_one[i] == '1' and check == 0:
        one_cnt += 1
        check = 1
       
    elif zero_one[i] == '0' and check == 1:
        zero_cnt += 1
        check = 0
    elif zero_one[i] == '1' and (check==2 or check==1):       
        check = 1
       
    elif zero_one[i] == '0' and (check==2 or check==0):
        check = 0
    

print(min(one_cnt, zero_cnt))

