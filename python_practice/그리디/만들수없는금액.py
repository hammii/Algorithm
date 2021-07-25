# 23:18 시작, 풀이 참고
import sys

N = int(sys.stdin.readline().rstrip())
coin = list(map(int, sys.stdin.readline().rstrip().split()))

coin.sort()
target = 1

for x in coin:
    if target < x:
        break
    target += x

print(target)
