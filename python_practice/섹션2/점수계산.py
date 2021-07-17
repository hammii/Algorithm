import sys

N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))
dp = [0] * N

dp[0] = arr[0]
for i in range(1, N):
    if dp[i - 1] == 0 and arr[i] == 1:
        dp[i] = arr[i]
    elif dp[i - 1] > 0 and arr[i] == 1:
        dp[i] = dp[i - 1] + 1

print(sum(dp))
