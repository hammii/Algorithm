import sys

N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))
dp = [1] * len(arr)

answer = 0
for i in range(len(arr)):
    for j in range(0, i):
        if arr[i] < arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(N - max(dp))
