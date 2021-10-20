import sys
import copy

maps = [[None] * 4 for _ in range(4)]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]
answer = 0


def find_horse(maps, idx):
    for i in range(4):
        for j in range(4):
            if maps[i][j][0] == idx:
                return (i, j)
    return None


def move_horse(maps, doduk_x, doduk_y):
    for i in range(1, 17):
        position = find_horse(maps, i)
        if position is None:
            continue

        x, y = position[0], position[1]
        dir = maps[x][y][1]
        for k in range(8):
            nx, ny = x + dx[dir], y + dy[dir]
            if 0 <= nx < 4 and 0 <= ny < 4 and not (nx == doduk_x and ny == doduk_y):
                maps[x][y][0], maps[nx][ny][0] = maps[nx][ny][0], maps[x][y][0]
                maps[x][y][1], maps[nx][ny][1] = maps[nx][ny][1], dir
                break
            dir = (dir + 1) % 8


def can_go(maps, doduk_x, doduk_y):
    positions = []
    dir = maps[doduk_x][doduk_y][1]
    for i in range(1, 4):
        nx, ny = doduk_x + dx[dir], doduk_y + dy[dir]
        if 0 <= nx < 4 and 0 <= ny < 4 and 1 <= maps[nx][ny][0] <= 16:
            positions.append([nx, ny])
        doduk_x, doduk_y = nx, ny
    return positions


def dfs(maps, x, y, total):
    global answer
    temp_maps = copy.deepcopy(maps)

    score = temp_maps[x][y][0]
    temp_maps[x][y][0] = -1

    move_horse(temp_maps, x, y)  # 말 움직이기
    positions = can_go(temp_maps, x, y)  # 도둑이 갈 수 있는 곳들
    answer = max(answer, total + score)
    for nx, ny in positions:
        dfs(temp_maps, nx, ny, total + score)


for i in range(4):
    line = list(map(int, sys.stdin.readline().rstrip().split()))

    for j in range(4):
        p, d = line[j * 2], line[j * 2 + 1]
        maps[i][j] = [p, d - 1]

dfs(maps, 0, 0, 0)
print(answer)
