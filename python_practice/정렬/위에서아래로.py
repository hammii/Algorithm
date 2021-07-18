# 15:17 시작, 15:20 종료
import sys

N = int(sys.stdin.readline().rstrip())
arr = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
arr.sort(reverse=True)

for a in arr:
    print(a, end=' ')
