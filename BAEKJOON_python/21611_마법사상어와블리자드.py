import sys
from collections import deque

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
magic_dx = [0, -1, 1, 0, 0]
magic_dy = [0, 0, 0, -1, 1]

N, M = map(int, sys.stdin.readline().rstrip().split())
maps = [[0] * (N + 1)] + [[0] + list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
info = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(M)]
start_x = (N + 1) // 2
start_y = (N + 1) // 2
order = []
answer = 0


def make_order():
    x, y = start_x, start_y
    order.append((x, y))
    d = 0
    step = 1
    while True:
        flag = False
        for _ in range(step):
            x, y = x + dx[d], y + dy[d]
            order.append((x, y))
            if x == 1 and y == 1:
                flag = True
                break
        if flag:
            break
        d = (d + 1) % 4
        if d % 2 == 0:
            step += 1


def move():
    q = deque()

    for x, y in order:
        if x == start_x and y == start_y:
            continue
        if maps[x][y] == 0:
            q.append((x, y))
        elif q:
            nx, ny = q.popleft()
            maps[nx][ny] = maps[x][y]
            maps[x][y] = 0
            q.append((x, y))


def boom():
    global answer
    q = deque()
    color = 0

    flag = False
    for x, y in order:
        if x == start_x and y == start_y:
            continue
        if maps[x][y] != color:
            if len(q) >= 4:
                answer += color * len(q)

                while q:
                    nx, ny = q.popleft()
                    maps[nx][ny] = 0
                    flag = True
            else:
                q.clear()
        q.append((x, y))
        color = maps[x][y]
    return flag


def change():
    q = deque()
    color = 0
    next_idx = 1
    temp = [[0] * (N + 1) for _ in range(N + 1)]

    for x, y in order:
        if x == start_x and y == start_y:
            continue
        if maps[x][y] != color:
            if not (x == start_x and y == start_y - 1):
                nx, ny = order[next_idx][0], order[next_idx][1]
                temp[nx][ny] = len(q)
                next_idx += 1

                nx, ny = order[next_idx][0], order[next_idx][1]
                temp[nx][ny] = color
                next_idx += 1
                q.clear()

                if next_idx >= len(order):
                    return temp
        q.append((x, y))
        color = maps[x][y]

    return temp


make_order()
for d, s in info:
    for i in range(s + 1):  # 블리자드
        nx, ny = start_x + magic_dx[d] * i, start_y + magic_dy[d] * i
        maps[nx][ny] = 0
    move()

    while True:
        if not boom():
            break
        else:
            move()

    maps = change()

print(answer)
