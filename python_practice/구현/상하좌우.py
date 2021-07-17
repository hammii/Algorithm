# 23:10 시작, 23:17 종료
import sys

N = int(sys.stdin.readline().rstrip())
x, y = 1, 1
dir = list(sys.stdin.readline().rstrip().split())

for d in dir:
    if d == 'L' and x > 1:
        x -= 1
    elif d == 'R' and x < N:
        x += 1
    elif d == 'U' and y > 1:
        y -= 1
    elif d == 'D' and y < N:
        y += 1

print(y, x)
