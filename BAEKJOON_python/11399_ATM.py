import sys

N = int(sys.stdin.readline().strip())
P = list(map(int, sys.stdin.readline().split()))
P.sort()

sum = 0
for i in range(len(P)):
    for j in range(0, i + 1):
        sum += P[j]

print(sum)
