import sys
from collections import Counter

N, M = map(int, sys.stdin.readline().rstrip().split())
arr = []
for i in range(1, N + 1):
    for j in range(1, M + 1):
        arr.append(i + j)

cnt = dict(Counter(arr))
max_cnt = max(cnt.values())

for key, value in cnt.items():
    if value == max_cnt:
        print(key, end=' ')
