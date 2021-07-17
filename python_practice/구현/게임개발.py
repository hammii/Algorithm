# 23:58 시작, 00:15 종료
import sys

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

N, M = map(int, sys.stdin.readline().rstrip().split())
A, B, d = map(int, sys.stdin.readline().rstrip().split())
my_map = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]

cnt = 0
while True:
    flag = False
    my_map[A][B] = 1
    cnt += 1

    for i in range(4):
        next_r = A + dr[(i + 3) % 4]
        next_c = B + dc[(i + 3) % 4]
        if my_map[next_r][next_c] == 0:
            A, B = next_r, next_c
            d = i
            flag = True
            break

    if not flag:
        next_r = A + dr[(d + 2) % 4]
        next_c = B + dc[(d + 2) % 4]
        if my_map[next_r][next_c] == 0:
            A, B = next_r, next_c
        else:
            break

print(cnt)
