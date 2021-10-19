import sys

n, m, q = map(int, sys.stdin.readline().rstrip().split())
maps = [[0] * (m + 1)] + [[0] + list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def rotate(x, d, k):
    for r in range(1, n + 1):
        if r % x != 0:
            continue

        if d == 0:  # 시계 방향
            for i in range(k):
                temp = maps[r][m]
                for c in range(m, 1, -1):
                    maps[r][c] = maps[r][c - 1]
                maps[r][1] = temp
        else:  # 반시계 방향
            for i in range(k):
                temp = maps[r][1]
                for c in range(1, m):
                    maps[r][c] = maps[r][c + 1]
                maps[r][m] = temp


def check_adj(x, y):
    flag = False
    for k in range(4):
        nx = x + dx[k]
        ny = y + dy[k]
        if nx <= 0 or nx > n:
            continue
        if ny <= 0:
            ny = m
        if ny > m:
            ny = 1
        if maps[x][y] == maps[nx][ny]:
            checked[x][y] = True
            checked[nx][ny] = True
            flag = True
    return flag


def get_avg():
    total = 0
    cnt = 0
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if maps[i][j] <= 0:
                continue
            total += maps[i][j]
            cnt += 1
    return total // cnt


def remove_adj():
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if maps[i][j] > 0 and checked[i][j]:
                maps[i][j] = 0


def check_maps():
    remove_flag = False
    avg = 0
    for r in range(1, n + 1):
        for c in range(1, m + 1):
            if maps[r][c] != 0 and check_adj(r, c):
                remove_flag = True

    if not remove_flag:  # 지워지는 수가 없는 경우
        avg = get_avg()
    else:
        remove_adj()
    return avg


def normalize(average):
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if maps[i][j] == 0:
                continue
            if maps[i][j] > average:
                maps[i][j] -= 1
            elif maps[i][j] < average:
                maps[i][j] += 1


def sum_remain():
    answer = 0
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            answer += maps[i][j]
    return answer


for i in range(q):
    x, d, k = map(int, sys.stdin.readline().rstrip().split())
    checked = [[False] * (m + 1) for _ in range(n + 1)]

    rotate(x, d, k)
    avg = check_maps()
    if avg != 0:
        normalize(avg)

print(sum_remain())
