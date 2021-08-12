import sys


def check(x, y):
    if x < 0 or y < 0 or x >= N or y >= N or house[x][y] == 1:
        return False
    return True


def dfs(x, y, d):
    global answer

    if x == N - 1 and y == N - 1:
        answer += 1
        return

    if d == 0:  # 가로 방향인 경우
        if check(x, y + 1):
            dfs(x, y + 1, 0)
        if check(x, y + 1) and check(x + 1, y) and check(x + 1, y + 1):
            dfs(x + 1, y + 1, 1)
    elif d == 2:  # 세로 방향인 경우
        if check(x + 1, y):
            dfs(x + 1, y, 2)
        if check(x, y + 1) and check(x + 1, y) and check(x + 1, y + 1):
            dfs(x + 1, y + 1, 1)
    else:  # 대각선 방향인 경우
        if check(x, y + 1):
            dfs(x, y + 1, 0)
        if check(x + 1, y):
            dfs(x + 1, y, 2)
        if check(x, y + 1) and check(x + 1, y) and check(x + 1, y + 1):
            dfs(x + 1, y + 1, 1)


N = int(sys.stdin.readline().rstrip())
house = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
answer = 0

if house[N - 1][N - 1] == 1:
    print(0)
else:
    dfs(0, 1, 0)
    print(answer)
