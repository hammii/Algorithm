# 13:53 시작, 14:08 종료
import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())
maze = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y, cnt):
    queue = deque()
    queue.append((x, y))
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()

        if x == N - 1 and y == M - 1:
            cnt += 1
            break

        flag = False
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and maze[nx][ny] == 1:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    flag = True
        if flag:
            cnt += 1

    return cnt


print(bfs(0, 0, 0))
