# 14:28 시작, 14:36 종료
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
weight = list(map(int, sys.stdin.readline().rstrip().split()))
cnt = 0

for i in range(N):
    for j in range(i + 1, N):
        if weight[i] != weight[j]:
            cnt += 1

print(cnt)
