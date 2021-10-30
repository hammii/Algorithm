from collections import deque

N, M, K = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(N)]
dice = [[0, 2, 0], [4, 6, 3], [0, 5, 0]]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
x, y, d = 0, 0, 0
answer = 0


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited = [[False] * M for _ in range(N)]
    visited[x][y] = True
    origin = maps[x][y]
    score = origin

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if maps[nx][ny] == origin:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    score += maps[nx][ny]
    return score


for _ in range(K):
    if not (0 <= x + dx[d] < N and 0 <= y + dy[d] < M):
        d = (d + 2) % 4
    x = x + dx[d]
    y = y + dy[d]

    if d == 0:
        for i in range(2):
            dice[1][i] = dice[1][i + 1]
        dice[1][2] = 7 - dice[1][0]
    elif d == 1:
        for i in range(2):
            dice[i][1] = dice[i + 1][1]
        dice[2][1] = 7 - dice[0][1]
    elif d == 2:
        for i in range(2, 0, -1):
            dice[1][i] = dice[1][i - 1]
        dice[1][0] = 7 - dice[1][2]
    elif d == 3:
        for i in range(2, 0, -1):
            dice[i][1] = dice[i - 1][1]
        dice[0][1] = 7 - dice[2][1]

    answer += bfs(x, y)

    if dice[1][1] > maps[x][y]:
        d = (d + 1) % 4
    elif dice[1][1] < maps[x][y]:
        d = (d - 1)
        if d == -1:
            d = 3

print(answer)
