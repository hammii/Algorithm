import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if bachu[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = True


T = int(sys.stdin.readline().rstrip())

while T > 0:
    M, N, K = map(int, sys.stdin.readline().rstrip().split())
    bachu = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    answer = 0

    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().rstrip().split())
        bachu[Y][X] = 1

    for i in range(N):
        for j in range(M):
            if bachu[i][j] == 1 and not visited[i][j]:
                answer += 1
                bfs(i, j)

    print(answer)
    T -= 1
