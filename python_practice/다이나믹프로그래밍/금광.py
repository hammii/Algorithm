# 0:18 시작, 0:42 종료
import sys

T = int(sys.stdin.readline().rstrip())
while T:
    n, m = map(int, sys.stdin.readline().rstrip().split())
    my_map = [[0] * (m + 1) for _ in range(n + 2)]
    dp = [[0] * (m + 1) for _ in range(n + 2)]
    line = list(map(int, sys.stdin.readline().rstrip().split()))

    cnt = 0
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            my_map[i][j] = line[cnt]
            cnt += 1

    last = []
    for col in range(1, m + 1):
        for row in range(1, n + 1):
            dp[row][col] = max(dp[row - 1][col - 1], dp[row][col - 1], dp[row + 1][col - 1]) + my_map[row][col]
            if col == m:
                last.append(dp[row][col])

    print(max(last))
    T -= 1
