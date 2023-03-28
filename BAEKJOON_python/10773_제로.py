import sys

K = int(sys.stdin.readline().rstrip())
stack = []

for _ in range(K):
    num = int(sys.stdin.readline().rstrip())
    if num == 0:
        if stack:
            stack.pop()
    else:
        stack.append(num)
        
print(sum(stack))
        
