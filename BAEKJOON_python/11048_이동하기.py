import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
maze = [[0] * (M + 1) for _ in range(N + 1)]
dp = [[0] * (M + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    maze[i] = list(map(int, sys.stdin.readline().rstrip().split()))
    maze[i].insert(0, 0)

dp[1][1] = maze[1][1]

for i in range(1, N + 1):
    for j in range(1, M + 1):
        if i == 1 and j == 1:
            continue
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + maze[i][j]

print(dp[N][M])
