import sys

N, K = map(int, sys.stdin.readline().rstrip().split())
w_list = [0]
v_list = [0]
dp = [[0 for _ in range(K + 1)] for _ in range(N + 1)]

for _ in range(N):
    W, V = map(int, sys.stdin.readline().rstrip().split())
    w_list.append(W)
    v_list.append(V)

for i in range(1, N + 1):
    for w in range(1, K + 1):
        if i == 0 or w == 0:
            dp[i][w] = 0
        elif w_list[i] <= w:
            dp[i][w] = max(v_list[i] + dp[i - 1][w - w_list[i]], dp[i - 1][w])
        else:
            dp[i][w] = dp[i - 1][w]

print(dp[N][K])
