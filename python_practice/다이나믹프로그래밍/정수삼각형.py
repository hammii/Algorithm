# 16:53 시작, 17:09 종료
import sys

n = int(sys.stdin.readline().rstrip())
arr = [[0] * n for _ in range(n)]
dp = [[0] * n for _ in range(n)]

for i in range(n):
    arr[i] = list(map(int, sys.stdin.readline().rstrip().split()))

dp[0][0] = arr[0][0]
for i in range(1, n):
    for j in range(len(arr[i])):
        if j == 0:
            dp[i][j] = dp[i - 1][0] + arr[i][j]
        elif j == len(arr[i]) - 1:
            dp[i][j] = dp[i - 1][j - 1] + arr[i][j]
        else:
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j]

print(max(dp[n - 1]))
