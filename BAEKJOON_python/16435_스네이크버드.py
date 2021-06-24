import sys

N, L = map(int, sys.stdin.readline().rstrip().split())
h = list(map(int, sys.stdin.readline().rstrip().split()))

h = sorted(h)

for height in h:
    if height <= L:
        L += 1
    else:
        break

print(L)
