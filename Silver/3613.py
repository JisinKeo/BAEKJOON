import sys

string = input()
underbar = 0
big = 0
if ord(string[0])>=65 and ord(string[0])<=95:
        print("Error!")
        sys.exit(0)    
for i in range(len(string)):
    if ord(string[i]) == 95 and len(string)-1==i:
        print("Error!")
        sys.exit(0)
    if ord(string[i]) == 95 and ord(string[i+1])==95:
        print("Error!")
        sys.exit(0)
       
    if ord(string[i]) == 95 :
        underbar = 1 # c++
    if (ord(string[i])>=65 and ord(string[i])<=90):
        big = 1 #java
        

if big == 1 and underbar == 1:
    print("Error!")
    
elif underbar == 1:
    string = string.split('_')
    result = string[0]
    for j in range(1, len(string)):
        string[j] = string[j].capitalize()
        result = result + string[j]
    print(result)

elif big == 1:
    j = 0
    for i in range(len(string)):
        if (ord(string[i])>=65 and ord(string[i])<=90):
            result = string[0:i] + '_' + string[i].lower()
            print(result, end='')
            j = i
            break
    for i in range(j+1, len(string)):
        if (ord(string[i])>=65 and ord(string[i])<=90):    
            result = string[j+1:i]+'_'+string[i].lower()
            j = i
            print(result, end='')
    result = string[j+1:len(string)]
    print(result, end='')

else:
    print(string)
