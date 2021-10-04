import sys

T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    n = int(sys.stdin.readline().rstrip())
    dp = [[0 for col in range(n + 1)] for row in range(2)]
    possible = [[True for col in range(n + 1)] for row in range(2)]
    num = [list(map(int, sys.stdin.readline().rstrip().split())) for row in range(2)]

    dp[0][0] = num[0][0]
    dp[1][0] = num[1][0]

    if n > 1:
        dp[0][1] = dp[1][0] + num[0][1]
        dp[1][1] = dp[0][0] + num[1][1]

    for col in range(2, n):
        dp[0][col] = max(dp[1][col - 2], dp[1][col - 1]) + num[0][col]
        dp[1][col] = max(dp[0][col - 2], dp[0][col - 1]) + num[1][col]

    print(max(dp[0][n - 1], dp[1][n - 1]))
