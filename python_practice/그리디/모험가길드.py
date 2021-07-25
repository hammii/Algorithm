# 22:28 시작, 22:46 종료
import sys

N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

arr.sort()

answer = 0
cnt = 0  # 그룹 내 모험가 수

for i in arr:
    cnt += 1
    if cnt >= i:
        answer += 1
        cnt = 0

print(answer)
