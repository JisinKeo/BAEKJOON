pathe = input()

stack = []
score = 0
mul = 1
check = 0
for x in pathe:
    if x == '(':
        stack.append(x)
        mul *= 2
        check = 0
    elif x == '[':
        stack.append(x)
        mul *= 3
        check = 0
    elif x == ')':
        if not stack or stack[-1] == '[':
            score = 0
            break
        elif stack[-1] == '(':
            if check == 0:
                score += mul
                check = 1
            mul /= 2
            stack.pop()
    elif x == ']':
        if not stack or stack[-1] == '(':
            score = 0
            break
        elif stack[-1] == '[':
            if check == 0:
                score += mul
                check = 1
            mul /= 3
            stack.pop()
        


if stack:
    print(0)
else:
    print(int(score))
                
            
