import sys

n, m, t = map(int, sys.stdin.readline().rstrip().split())
maps = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
answer = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def spread():
    next_maps = [[0] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if maps[i][j] == -1:
                continue

            mod = maps[i][j] // 5
            cnt = 0

            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] != -1:
                    next_maps[nx][ny] += mod
                    cnt += 1

            next_maps[i][j] += maps[i][j] - mod * cnt

    for i in range(n):
        for j in range(m):
            if maps[i][j] != -1:
                maps[i][j] = next_maps[i][j]


def rotate_top(start):
    for i in range(start - 1, 0, -1):
        maps[i][0] = maps[i - 1][0]
    for j in range(m - 1):
        maps[0][j] = maps[0][j + 1]
    for i in range(0, start):
        maps[i][m - 1] = maps[i + 1][m - 1]
    for j in range(m - 1, 0, -1):
        if j == 1:
            maps[start][j] = 0
        else:
            maps[start][j] = maps[start][j - 1]


def rotate_bottom(start):
    for i in range(start + 1, n - 1):
        maps[i][0] = maps[i + 1][0]
    for j in range(m - 1):
        maps[n - 1][j] = maps[n - 1][j + 1]
    for i in range(n - 1, start, -1):
        maps[i][m - 1] = maps[i - 1][m - 1]
    for j in range(m - 1, 0, -1):
        if j == 1:
            maps[start][j] = 0
        else:
            maps[start][j] = maps[start][j - 1]


# 디버깅
# def print_maps():
#     for i in range(n):
#         for j in range(m):
#             print(maps[i][j], end=' ')
#         print()


tornado = 0
for row in range(n):
    if maps[row][0] == -1:
        tornado = row
        break

for i in range(t):
    spread()
    rotate_top(tornado)
    rotate_bottom(tornado + 1)

for i in range(n):
    for j in range(m):
        if maps[i][j] != -1:
            answer += maps[i][j]
print(answer)
