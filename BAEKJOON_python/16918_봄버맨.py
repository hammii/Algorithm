import sys

R, C, N = map(int, sys.stdin.readline().rstrip().split())
map = [[] * C for _ in range(R)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(R):
    map[i] = list(sys.stdin.readline().rstrip())


def checkBomb(map):
    bomb = []
    for i in range(R):
        for j in range(C):
            if map[i][j] == 'O':
                bomb.append((i, j))
    return bomb


def fillMap():
    copy_map = [['O'] * C for _ in range(R)]
    return copy_map


def boom(map, bomb):  # 200 * 200 * 4 = 160,000
    while bomb:
        x, y = bomb.pop()
        map[x][y] = '.'
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < R and 0 <= ny < C:
                map[nx][ny] = '.'

    return map


time = 1
while True:
    bomb = checkBomb(map)  # 폭탄 체크
    if time == N:
        break

    time += 1
    map = fillMap()  # 폭탄 설치
    if time == N:
        break

    time += 1
    map = boom(map, bomb)  # 폭발 후
    if time == N:
        break

for i in range(len(map)):
    print(''.join(map[i]))
