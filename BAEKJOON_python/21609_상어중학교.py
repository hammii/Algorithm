import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
maps = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
answer = 0


def bfs(start_x, start_y):
    q = deque()
    q.append((start_x, start_y, maps[start_x][start_y]))
    checked = [[False] * N for _ in range(N)]
    checked[start_x][start_y] = True
    visited[start_x][start_y] = True

    default_color = maps[start_x][start_y]
    size, zero_cnt = 1, 0

    while q:
        x, y, color = q.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]

            if not (0 <= nx < N and 0 <= ny < N) or checked[nx][ny]:
                continue
            if maps[nx][ny] is None or maps[nx][ny] == -1:
                continue
            if maps[nx][ny] != default_color and maps[nx][ny] != 0:
                continue
            if maps[nx][ny] == 0:
                zero_cnt += 1
            if maps[nx][ny] > 0:
                visited[nx][ny] = True

            q.append((nx, ny, maps[nx][ny]))
            checked[nx][ny] = True
            size += 1

    return (size, checked, zero_cnt)


def rotate_maps(maps):
    temp = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            temp[N - j - 1][i] = maps[i][j]
    return temp


def dropdown_maps(maps):
    for i in range(N - 1, -1, -1):
        for j in range(N):
            if maps[i][j] is None:  # 빈 공간일 경우
                for k in range(i - 1, -1, -1):
                    if maps[k][j] == -1:
                        break
                    if maps[k][j] is not None and maps[k][j] > -1:
                        maps[i][j] = maps[k][j]
                        maps[k][j] = None
                        break
    return maps


while True:
    visited = [[False] * N for _ in range(N)]
    max_size, max_rainbow, max_row, max_col = 0, 0, 0, 0
    remove_maps = []

    for i in range(N):
        for j in range(N):
            if maps[i][j] is None or visited[i][j] or maps[i][j] <= 0:
                continue
            size, checked, rainbow = bfs(i, j)
            visited[i][j] = True
            if size > max_size:
                max_size, max_rainbow = size, rainbow
                remove_maps = checked
                max_row, max_col = i, j
            elif size == max_size:
                if rainbow > max_rainbow:
                    max_size, max_rainbow = size, rainbow
                    remove_maps = checked
                    max_row, max_col = i, j
                elif rainbow == max_rainbow:
                    if i > max_row:
                        max_size, max_rainbow = size, rainbow
                        remove_maps = checked
                        max_row, max_col = i, j
                    elif i == max_row:
                        if j > max_col:
                            max_size, max_rainbow = size, rainbow
                            remove_maps = checked
                            max_row, max_col = i, j

    if max_size >= 2:
        score = 0
        for i in range(N):
            for j in range(N):
                if remove_maps[i][j] is True:
                    maps[i][j] = None
                    score += 1
        answer += score ** 2
    else:
        break

    maps = dropdown_maps(maps)
    maps = rotate_maps(maps)
    maps = dropdown_maps(maps)

print(answer)
