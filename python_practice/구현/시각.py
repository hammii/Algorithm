# 23:20 시작, 23:33 종료
import sys

N = int(sys.stdin.readline().rstrip())
cnt = 0
for i in range(N + 1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                cnt += 1

print(cnt)
