import sys

dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dy = [0, -1, -1, 0, 1, 1, 1, 0, -1]

N, M = map(int, sys.stdin.readline().rstrip().split())
maps = [[0] * (N + 1)] + [[0] + list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
info = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(M)]
cloud_maps = [[False] * (N + 1) for _ in range(N + 1)]


def move_clouds(cloud, d, s):
    temp = [[False] * (N + 1) for _ in range(N + 1)]
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if cloud[i][j]:
                nx, ny = i + dx[d] * s, j + dy[d] * s
                if nx < 1:
                    nx += N
                if nx > N:
                    nx -= N
                if ny < 1:
                    ny += N
                if ny > N:
                    ny -= N
                temp[nx][ny] = True
    return temp


cloud_maps[N][1] = True
cloud_maps[N][2] = True
cloud_maps[N - 1][1] = True
cloud_maps[N - 1][2] = True

for d, s in info:
    s %= N
    cloud_maps = move_clouds(cloud_maps, d, s)  # 1. 구름 이동
    rained_maps = [[False] * (N + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):  # 2. 물의 양 1 증가
        for j in range(1, N + 1):
            if cloud_maps[i][j]:
                maps[i][j] += 1
                rained_maps[i][j] = True

    cloud_maps = [[False] * (N + 1) for _ in range(N + 1)]  # 3. 구름 사라짐

    for i in range(1, N + 1):  # 4. 물복사버그
        for j in range(1, N + 1):
            cnt = 0
            if rained_maps[i][j]:
                for k in range(2, 9, 2):
                    nx, ny = i + dx[k], j + dy[k]
                    if 0 < nx <= N and 0 < ny <= N and maps[nx][ny] > 0:
                        cnt += 1
            maps[i][j] += cnt

    for i in range(1, N + 1):  # 5.
        for j in range(1, N + 1):
            if maps[i][j] >= 2 and not rained_maps[i][j]:
                cloud_maps[i][j] = True
                maps[i][j] -= 2

answer = 0
for i in range(1, N + 1):
    for j in range(1, N + 1):
        if maps[i][j]:
            answer += maps[i][j]
print(answer)
