# 13:41 시작, 13:53 종료
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
arr = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y):
    visited[x][y] = True
    flag = False

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if not visited[nx][ny] and arr[nx][ny] == 0:
                dfs(nx, ny)
                flag = True

    if not flag:
        return


cnt = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0 and not visited[i][j]:
            cnt += 1
            dfs(i, j)

print(cnt)
