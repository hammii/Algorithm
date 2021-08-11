import sys

n = int(sys.stdin.readline().rstrip())
arr = [int(sys.stdin.readline().rstrip()) for _ in range(n)]
arr.insert(0, 0)
dp = [0] * (n + 1)

dp[1] = arr[1]
if n > 1:
    dp[2] = dp[1] + arr[2]

    for i in range(3, n + 1):
        dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i])

print(dp[n])
