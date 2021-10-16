import sys

BLANK = (-1, -1, -1)
dx = [0, -1, 1, 0, 0]  # 위, 아래, 오른쪽, 왼쪽
dy = [0, 0, 0, 1, -1]

n, m, k = map(int, sys.stdin.readline().rstrip().split())
maps = [[BLANK] * (m + 1) for _ in range(n + 1)]
next_maps = [[BLANK] * (m + 1) for _ in range(n + 1)]
answer = 0


# 디버깅
# def print_maps():
#     for i in range(1, n + 1):
#         for j in range(1, m + 1):
#             print(maps[i][j], end=' ')
#         print()


def collect(col):
    global answer
    for row in range(n + 1):
        if maps[row][col] != BLANK:
            answer += maps[row][col][0]
            maps[row][col] = BLANK
            break


def move_all():
    for i in range(n + 1):
        for j in range(m + 1):
            next_maps[i][j] = BLANK

    for i in range(n + 1):
        for j in range(m + 1):
            if maps[i][j] != BLANK:
                move(i, j)

    for i in range(n + 1):
        for j in range(m + 1):
            maps[i][j] = next_maps[i][j]


def move(x, y):
    b, s, d = maps[x][y]

    for _ in range(s):
        nx = x + dx[d]
        ny = y + dy[d]

        if 0 < nx <= n and 0 < ny <= m:
            x, y = nx, ny
        else:
            if d % 2 == 0:
                d -= 1
            else:
                d += 1
            x, y = x + dx[d], y + dy[d]

    if b > next_maps[x][y][0]:
        next_maps[x][y] = (b, s, d)


for _ in range(k):
    x, y, s, d, b = map(int, sys.stdin.readline().rstrip().split())

    if d <= 2:  # 상하
        s %= (2 * n - 2)
    else:  # 좌우
        s %= (2 * m - 2)
    maps[x][y] = (b, s, d)

for j in range(1, m + 1):
    collect(j)
    move_all()

print(answer)
