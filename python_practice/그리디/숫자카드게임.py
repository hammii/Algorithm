# 21:54 시작, 22:02 종료
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
num = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
min_arr = [0] * N

for i in range(N):
    min_arr[i] = min(num[i])

print(max(min_arr))
