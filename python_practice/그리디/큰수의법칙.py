# 21:32 시작, 21:46 종료
import sys

N, M, K = map(int, sys.stdin.readline().rstrip().split())
num = list(map(int, sys.stdin.readline().rstrip().split()))
ans = 0

num.sort(reverse=True)
while M > 0:
    for _ in range(K):
        ans += num[0]
        M -= 1
    ans += num[1]
    M -= 1

print(ans)
