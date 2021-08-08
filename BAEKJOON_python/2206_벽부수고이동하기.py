import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
my_map = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(N)]
visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    q = deque()
    q.append((x, y, 1))
    visited[x][y][1] = 1

    while q:
        x, y, w = q.popleft()
        if x == N - 1 and y == M - 1:
            return visited[x][y][w]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if my_map[nx][ny] == 1 and w == 1:  # 벽을 뚫을 수 있는 상태일 때
                    visited[nx][ny][0] = visited[x][y][1] + 1
                    q.append((nx, ny, 0))
                elif my_map[nx][ny] == 0 and visited[nx][ny][w] == 0:
                    visited[nx][ny][w] = visited[x][y][w] + 1
                    q.append((nx, ny, w))
    return -1


print(bfs(0, 0))
