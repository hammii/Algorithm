import sys
from collections import deque

n, q = map(int, sys.stdin.readline().rstrip().split())
N = 2 ** n
maps = [[0] * (N + 1)] + [[0] + list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
level = list(map(int, sys.stdin.readline().rstrip().split()))
visited = [[False] * (N + 1) for _ in range(N + 1)]

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
total = 0
max_size = 0


def rotate(x, y, length):
    temp = [[0] * (N + 1) for _ in range(N + 1)]

    for i in range(length):
        for j in range(length):
            temp[j][length - i - 1] = maps[x + i][y + j]

    for i in range(length):
        for j in range(length):
            maps[x + i][y + j] = temp[i][j]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    cnt = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 < nx <= N and 0 < ny <= N:
                if not visited[nx][ny] and maps[nx][ny] > 0:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    cnt += 1

    return cnt


for l in level:
    for i in range(1, N + 1, 2 ** l):  # 회전
        for j in range(1, N + 1, 2 ** l):
            rotate(i, j, 2 ** l)

    checked = [[False] * (N + 1) for _ in range(N + 1)]
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            cnt = 0
            for k in range(4):
                nx, ny = i + dx[k], j + dy[k]
                if 0 < nx <= N and 0 < ny <= N:
                    if maps[nx][ny] > 0:
                        cnt += 1
            if cnt < 3:
                checked[i][j] = True

    for i in range(1, N + 1):  # 얼음 녹이기
        for j in range(1, N + 1):
            if checked[i][j] and maps[i][j] > 0:
                maps[i][j] -= 1

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if maps[i][j] > 0:
            total += maps[i][j]
            if not visited[i][j]:
                max_size = max(bfs(i, j), max_size)

print(total)
print(max_size)
