import sys

n = int(sys.stdin.readline())
num = []
dp = [0] * n

for _ in range(n):
    num.append(int(sys.stdin.readline()))

dp[0] = num[0]
if n > 1:
    dp[1] = num[0] + num[1]

for i in range(2, n):
    num1 = dp[i - 1]
    num2 = dp[i - 2] + num[i]
    if i == 2:
        num3 = num[i - 1] + num[i]
    else:
        num3 = dp[i - 3] + num[i - 1] + num[i]

    dp[i] = max(num1, num2, num3)

print(dp[n - 1])
