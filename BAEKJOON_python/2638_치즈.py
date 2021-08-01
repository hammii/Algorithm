import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N, M = map(int, sys.stdin.readline().rstrip().split())
map = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]  # -1: 외부 공기, 0: 내부 공기, 1: 치즈
visited = [[False] * M for _ in range(N)]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        map[x][y] = -1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if (map[nx][ny] == 0 or map[nx][ny] == -1) and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = True


def writeC(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    c_list = []

    while q:
        x, y = q.popleft()
        cnt = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if map[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                if map[nx][ny] == -1:
                    cnt += 1

        if cnt >= 2:
            map[x][y] = 3

    return c_list


time = 0
while True:
    bfs(0, 0)  # 외부 공기 표시

    visited = [[False] * M for _ in range(N)]
    flag = False
    for i in range(N):
        for j in range(M):
            if map[i][j] == 1 and not visited[i][j]:
                flag = True
                writeC(i, j)

    if not flag:
        break

    for i in range(N):
        for j in range(M):
            if map[i][j] == 3:
                map[i][j] = -1

    visited = [[False] * M for _ in range(N)]
    time += 1

print(time)
