# 16:00 시작, 16:27 종료
import sys

INF = 987654321

N, M = map(int, sys.stdin.readline().rstrip().split())
arr = [int(sys.stdin.readline().rstrip()) for _ in range(N)]
dp = [INF] * 10001

for a in arr:
    dp[a] = 1

for i in range(2, M + 1):
    if dp[i] == 1:
        continue

    for a in arr:
        dp[i] = min(dp[i], dp[i - a] + 1)

if dp[M] == INF:
    print(-1)
else:
    print(dp[M])
