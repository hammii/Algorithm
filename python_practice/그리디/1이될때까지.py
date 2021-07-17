# 22:04 시작, 22:11 종료
import sys

N, K = map(int, sys.stdin.readline().rstrip().split())
cnt = 0

while N != 1:
    if N % K == 0:
        N = N // K
    else:
        N -= 1
    cnt += 1

print(cnt)
