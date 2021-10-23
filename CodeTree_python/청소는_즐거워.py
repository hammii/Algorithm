import sys

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
ratio = [2, 10, 7, 1, 5, 10, 7, 1, 2]
ratio_dx = [[-2, -1, -1, -1, 0, 1, 1, 1, 2], [0, 1, 0, -1, 2, 1, 0, -1, 0],
            [-2, -1, -1, -1, 0, 1, 1, 1, 2], [0, -1, 0, 1, -2, -1, 0, 1, 0]]
ratio_dy = [[0, -1, 0, 1, -2, -1, 0, 1, 0], [-2, -1, -1, -1, 0, 1, 1, 1, 2],
            [0, 1, 0, -1, 2, 1, 0, -1, 0], [-2, -1, -1, -1, 0, 1, 1, 1, 2]]

N = int(sys.stdin.readline().rstrip())
maps = [[0] * (N + 1)] + [[0] + list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
x, y = (N + 1) // 2, (N + 1) // 2
answer = 0


def calculate(x, y, d):
    global answer
    alpha = maps[x][y]

    for i in range(len(ratio)):  # 비율 계산
        r = int(maps[x][y] * ratio[i] * 0.01)
        nx, ny = x + ratio_dx[d][i], y + ratio_dy[d][i]
        if 0 < nx <= N and 0 < ny <= N:  # 맵 안에 있을 경우
            maps[nx][ny] += r
        else:
            answer += r
        alpha -= r

    nx, ny = x + dx[d], y + dy[d]  # 알파 계산
    if 0 < nx <= N and 0 < ny <= N:
        maps[nx][ny] += alpha
    else:
        answer += alpha

    maps[x][y] = 0
    return maps


d = 0
step = 1
while True:
    flag = False
    for _ in range(step):
        x, y = x + dx[d], y + dy[d]
        maps = calculate(x, y, d)
        if x == 1 and y == 1:
            flag = True
            break
    if flag:
        break

    d = (d + 1) % 4
    if d % 2 == 0:
        step += 1

print(answer)
