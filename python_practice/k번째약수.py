import sys

N, K = map(int, sys.stdin.readline().split())
result = []

for i in range(1, N + 1):
    if N % i == 0:
        result.append(i)

if K <= len(result):
    print(result[K - 1])
else:
    print(-1)
