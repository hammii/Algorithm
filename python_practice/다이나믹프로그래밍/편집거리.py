# 1:33 시작, 참고 풀이
import sys

origin = list(sys.stdin.readline().rstrip())
change = list(sys.stdin.readline().rstrip())
n = len(origin)
m = len(change)

dp = [[0] * (m + 1) for _ in range(n + 1)]

for i in range(1, n + 1):
    dp[i][0] = i
for j in range(1, m + 1):
    dp[0][j] = j

for i in range(1, n + 1):
    for j in range(1, m + 1):
        if origin[i - 1] == change[j - 1]:
            dp[i][j] = dp[i - 1][j - 1]
        else:
            dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1

print(dp[n][m])
