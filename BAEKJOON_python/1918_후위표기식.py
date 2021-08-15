import sys

line = list(sys.stdin.readline().rstrip())
stack = []

for l in line:
    if 'A' <= l <= 'Z':  # 알파벳이면 바로 출력
        print(l, end='')
    else:
        if l == '(':
            stack.append(l)
        elif l == ')':
            while stack and stack[-1] != '(':
                print(stack.pop(), end='')
            stack.pop()
        elif l == '*' or l == '/':
            while stack and (stack[-1] == '*' or stack[-1] == '/'):
                print(stack.pop(), end='')
            stack.append(l)
        elif l == '+' or l == '-':
            while stack and stack[-1] != '(':
                print(stack.pop(), end='')
            stack.append(l)

while stack:
    print(stack.pop(), end='')
