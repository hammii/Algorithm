# 1:16 시작, 풀이 참고
import sys

n = int(sys.stdin.readline().rstrip())
ugly = [0] * n
ugly[0] = 1

m2 = m3 = m5 = 0  # 곱하기 위한 인덱스
next2, next3, next5 = 2, 3, 5

for i in range(1, n):
    ugly[i] = min(next2, next3, next5)
    if ugly[i] == next2:
        m2 += 1
        next2 = ugly[m2] * 2
    if ugly[i] == next3:
        m3 += 1
        next3 = ugly[m3] * 3
    if ugly[i] == next5:
        m5 += 1
        next5 = ugly[m3] * 5
