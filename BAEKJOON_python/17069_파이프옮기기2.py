import sys

N = int(sys.stdin.readline().rstrip())
house = [[0] for _ in range(N + 1)]
for i in range(N):
    house[i + 1] += list(map(int, sys.stdin.readline().rstrip().split()))

dp = [[[0] * 3 for _ in range(N + 1)] for _ in range(N + 1)]
dp[1][2][0] = 1

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if house[i][j] == 1 or (i == 1 and j == 2):
            continue

        for d in range(3):
            if d == 0:
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1]
            elif d == 1:
                if i - 1 == 0 or j - 1 == 0 or house[i - 1][j] == 1 or house[i][j - 1] == 1:
                    continue
                dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
            else:
                dp[i][j][2] = dp[i - 1][j][2] + dp[i - 1][j][1]

print(sum(dp[N][N]))
