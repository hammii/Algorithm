import sys
input = sys.stdin.readline

num = int(input())
arr = [list(input()) for _ in range(num)]

for line in arr:
    stack = []
    answer = 'YES'
    for l in line:
        if l == '(':
            stack.append('(')
        elif l == ')':
            if len(stack) == 0 or stack.pop() == ')':
                answer = 'NO'
                break

    if len(stack) > 0:
        answer = 'NO'

    print(answer)
