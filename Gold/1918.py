s = input()
stack = []
result = []

for i in range(len(s)):
    if ord(s[i])>=65 and ord(s[i])<=90:
        result.append(s[i])
    elif s[i]=='+' or s[i]=='-':
        if len(stack)>0:
            while stack[-1] =='*' or stack[-1]=='/' or stack[-1] =='+' or stack[-1]=='-':
                result.append(stack[-1])
                stack.pop()
                if len(stack)==0:
                    break
        stack.append(s[i])      
    elif s[i]=='*' or s[i]=='/':
        if len(stack)>0:
            if stack[-1] =='*' or stack[-1]=='/':
                result.append(stack[-1])
                stack.pop()
        stack.append(s[i])
    elif s[i]=='(':
        stack.append(s[i])
    elif s[i]==')':
        while stack[-1] != '(':
            result.append(stack[-1])
            stack.pop()
        stack.pop()    
while len(stack)>0:
    result.append(stack[-1])
    stack.pop()
    
for i in range(len(result)):
    print(result[i], end='')
