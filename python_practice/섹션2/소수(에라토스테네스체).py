import sys
import math

N = int(sys.stdin.readline().rstrip())
arr = [True for _ in range(N + 1)]

for i in range(2, int(math.sqrt(N)) + 1):
    if arr[i] == True:
        j = 2
        while i * j <= N:
            arr[i * j] = False
            j += 1

cnt = 0
for i in range(2, N + 1):
    if arr[i] == True:
        cnt += 1

print(cnt)
