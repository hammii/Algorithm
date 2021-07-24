import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
map = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    count = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                if map[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    count += 1

    return count


cnt = []
for i in range(N):
    for j in range(N):
        if map[i][j] == 1 and not visited[i][j]:
            cnt.append(bfs(i, j))

cnt.sort()
print(len(cnt))
for c in cnt:
    print(c)
