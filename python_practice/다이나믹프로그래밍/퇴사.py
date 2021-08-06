# 19:47 시작, 20:13 종료
import sys

N = int(sys.stdin.readline().rstrip())
T = [0]
P = [0]
dp = [0] * (N + 2)

for _ in range(N):
    t, p = map(int, sys.stdin.readline().rstrip().split())
    T.append(t)
    P.append(p)

for i in range(N, 0, -1):
    if i + T[i] - 1 > N:    # 범위를 넘는 경우
        dp[i] = dp[i + 1]
    else:
        dp[i] = max(P[i] + dp[i + T[i]], dp[i + 1])  # 일하는 것과 일을 안하는 것 비교

print(dp[1])
