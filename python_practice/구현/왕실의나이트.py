# 23:34 시작, 23:50 종료
import sys

dir = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2), (1, -2), (-1, 2), (1, 2)]
col = {'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5, 'f': 6, 'g': 7, 'h': 8}

d = sys.stdin.readline().rstrip()
r = int(d[1])
c = col[d[0]]
cnt = 0

for i in range(8):
    next_r = r + dir[i][0]
    next_c = c + dir[i][1]
    if 1 <= next_r <= 8 and 1 <= next_c <= 8:
        cnt += 1

print(cnt)
