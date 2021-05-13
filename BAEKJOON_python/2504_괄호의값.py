line = input()
stack = []
answer = 0
temp = 1

for idx, c in enumerate(line):
    if c == '(':
        temp *= 2
        stack.append(c)
    elif c == '[':
        temp *= 3
        stack.append(c)
    elif c == ')' and (len(stack) == 0 or stack[-1] != '('):
        answer = 0
        break
    elif c == ']' and (len(stack) == 0 or stack[-1] != '['):
        answer = 0
        break
    elif c == ')':
        if line[idx - 1] == '(':
            answer += temp
        stack.pop()
        temp /= 2
    elif c == ']':
        if line[idx - 1] == '[':
            answer += temp
        stack.pop()
        temp /= 3

if answer == 0 or len(stack) != 0:
    print(0)
else:
    print(int(answer))
