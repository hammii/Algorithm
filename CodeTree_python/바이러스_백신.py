import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
INF = 1e9

N, M = map(int, sys.stdin.readline().rstrip().split())
maps = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
hospital_comb = []
answer = INF


def dfs(hospital_list, pick_list, idx):
    if idx == len(hospital_list):
        if len(pick_list) == M:
            hospital_comb.append(pick_list[:])
        return

    pick_list.append(hospital_list[idx])
    dfs(hospital_list, pick_list, idx + 1)
    pick_list.pop()
    dfs(hospital_list, pick_list, idx + 1)


def bfs(hospital_list):
    global answer
    q = deque([])
    visited = [[False] * N for _ in range(N)]
    time_maps = [[0] * N for _ in range(N)]

    for h in hospital_list:
        q.append((h[0], h[1], 0))
        visited[h[0]][h[1]] = True

    while q:
        x, y, cnt = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if maps[nx][ny] == 0 or maps[nx][ny] == -2:
                    q.append((nx, ny, cnt + 1))
                    visited[nx][ny] = True
                    time_maps[nx][ny] = cnt + 1

    time = 0
    for i in range(N):
        for j in range(N):
            if maps[i][j] == 0 and time_maps[i][j] == 0:
                return
            if maps[i][j] == 0:
                time = max(time, time_maps[i][j])
    answer = min(answer, time)


hospital = []
for i in range(N):
    for j in range(N):
        if maps[i][j] == 2:
            hospital.append((i, j))
            maps[i][j] = -2
        if maps[i][j] == 1:
            maps[i][j] = -1

dfs(hospital, [], 0)

for i in range(len(hospital_comb)):
    bfs(hospital_comb[i])

print(-1) if answer == INF else print(answer)
