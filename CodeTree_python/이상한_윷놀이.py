import sys
from collections import deque

dx = [0, 0, 0, -1, 1]  # 오른쪽, 왼쪽, 위, 아래
dy = [0, 1, -1, 0, 0]

n, k = map(int, sys.stdin.readline().rstrip().split())
color_maps = [[0] * (n + 1)] + [[0] + list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
maps = [[deque() for _ in range(n + 1)] for _ in range(n + 1)]
horse_info = [0]

for i in range(k):
    info = list(map(int, sys.stdin.readline().rstrip().split()))
    horse_info.append(info)
    maps[info[0]][info[1]] = deque([i + 1])


def move_horse(idx):
    x = horse_info[idx][0]
    y = horse_info[idx][1]
    d = horse_info[idx][2]
    nx, ny = x + dx[d], y + dy[d]

    if nx <= 0 or nx > n or ny <= 0 or ny > n or color_maps[nx][ny] == 2:
        if d % 2 == 0:
            horse_info[idx][2] -= 1
        else:
            horse_info[idx][2] += 1
        nx, ny = x + dx[horse_info[idx][2]], y + dy[horse_info[idx][2]]

    if nx <= 0 or nx > n or ny <= 0 or ny > n or color_maps[nx][ny] == 2:
        return True

    size = len(maps[x][y])

    if color_maps[nx][ny] == 0:  # 흰색
        find = False

        for k in range(size):
            cur = maps[x][y].popleft()
            if cur == idx:
                find = True
            if find:
                maps[nx][ny].append(cur)
                horse_info[cur][0] = nx
                horse_info[cur][1] = ny
            else:
                maps[x][y].append(cur)
    elif color_maps[nx][ny] == 1:  # 빨간색
        for k in range(size):
            cur = maps[x][y].pop()
            maps[nx][ny].append(cur)
            horse_info[cur][0] = nx
            horse_info[cur][1] = ny
            if cur == idx:
                break

    if len(maps[nx][ny]) >= 4:
        return False
    return True


answer = 1
flag = False
while True:
    for i in range(1, k + 1):
        if not move_horse(i):
            flag = True
            break
    if flag:
        break

    answer += 1
    if answer > 1000:
        answer = -1
        break

print(answer)
