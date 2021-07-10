import sys

T = int(sys.stdin.readline().rstrip())
lines = [sys.stdin.readline().rstrip().split() for _ in range(T)]

for i in range(T):
    for j in range(len(lines[i])):
        lines[i][j] = lines[i][j][::-1]

for i in range(T):
    for j in range(len(lines[i])):
        print(lines[i][j], end=' ')
    print()
