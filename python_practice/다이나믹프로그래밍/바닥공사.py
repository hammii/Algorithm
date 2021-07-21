# 15:42 시작, 15:57 종료
import sys

N = int(sys.stdin.readline().rstrip())
dp = [0] * (N + 1)
dp[1] = 1
dp[2] = 3

for i in range(3, N + 1):
    dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796796

print(dp[N])
