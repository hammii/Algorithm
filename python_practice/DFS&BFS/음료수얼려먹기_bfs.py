# 00:54 시작, 01:23 종료
import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N, M = map(int, sys.stdin.readline().rstrip().split())
arr = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
cnt = 0


def bfs(x, y):
    global cnt
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and arr[nx][ny] == 0:
                    queue.append((nx, ny))
                    visited[nx][ny] = True


for i in range(N):
    for j in range(M):
        if not visited[i][j] and arr[i][j] == 0:
            cnt += 1
            bfs(i, j)

print(cnt)
