import sys

blue_map = [[0] * 4 for _ in range(4)]
red_map = [[0] * 6 for _ in range(4)]
yellow_map = [[0] * 4 for _ in range(6)]
score = 0
block_cnt = 0


def fill_red(t, x, y):
    if t == 1:
        for c in range(6):
            if c == 5:
                red_map[x][c] = 1
            elif red_map[x][c] == 0 and red_map[x][c + 1] != 0:
                red_map[x][c] = 1
                break
    elif t == 2:
        for c in range(1, 6):
            if c == 5:
                red_map[x][c] = 1
                red_map[x][c - 1] = 1
            elif (red_map[x][c] == 0 and red_map[x][c - 1] == 0) and red_map[x][c + 1] != 0:
                red_map[x][c] = 1
                red_map[x][c - 1] = 1
                break
    elif t == 3:
        for c in range(6):
            if c == 5:
                red_map[x][c] = 1
                red_map[x + 1][c] = 1
            elif (red_map[x][c] == 0 and red_map[x + 1][c] == 0) and (
                    red_map[x][c + 1] != 0 or red_map[x + 1][c + 1] != 0):
                red_map[x][c] = 1
                red_map[x + 1][c] = 1
                break


def fill_yellow(t, x, y):
    if t == 1:
        for r in range(6):
            if r == 5:
                yellow_map[r][y] = 1
            elif yellow_map[r][y] == 0 and yellow_map[r + 1][y] != 0:
                yellow_map[r][y] = 1
                break
    elif t == 3:
        for r in range(1, 6):
            if r == 5:
                yellow_map[r][y] = 1
                yellow_map[r - 1][y] = 1
            elif (yellow_map[r][y] == 0 and yellow_map[r - 1][y] == 0) and yellow_map[r + 1][y] != 0:
                yellow_map[r][y] = 1
                yellow_map[r - 1][y] = 1
                break
    elif t == 2:
        for r in range(6):
            if r == 5:
                yellow_map[r][y] = 1
                yellow_map[r][y + 1] = 1
            elif (yellow_map[r][y] == 0 and yellow_map[r][y + 1] == 0) and (
                    yellow_map[r + 1][y] != 0 or yellow_map[r + 1][y + 1] != 0):
                yellow_map[r][y] = 1
                yellow_map[r][y + 1] = 1
                break


def check_red():
    global red_map, score
    temp = [[0] * 6 for _ in range(4)]
    col = 5

    for c in range(5, -1, -1):
        fill_flag = True
        for r in range(4):
            if red_map[r][c] == 0:
                fill_flag = False
                break
        if not fill_flag:  # 꽉찬 열이 아니라면
            for r in range(4):
                temp[r][col] = red_map[r][c]
            col -= 1
        else:
            score += 1
    red_map = temp

    cnt = 0
    for c in range(1, -1, -1):
        for r in range(4):
            if red_map[r][c] != 0:
                cnt += 1
                break

    temp = [[0] * 6 for _ in range(4)]
    col = 5
    for c in range(5 - cnt, -1, -1):
        for r in range(4):
            temp[r][col] = red_map[r][c]
        col -= 1
    red_map = temp


def check_yellow():
    global yellow_map, score
    temp = [[0] * 4 for _ in range(6)]
    row = 5

    for r in range(5, -1, -1):
        fill_flag = True
        for c in range(4):
            if yellow_map[r][c] == 0:
                fill_flag = False
                break
        if not fill_flag:  # 꽉찬 행이 아니라면
            for c in range(4):
                temp[row][c] = yellow_map[r][c]
            row -= 1
        else:
            score += 1
    yellow_map = temp

    cnt = 0
    for r in range(1, -1, -1):
        for c in range(4):
            if yellow_map[r][c] != 0:
                cnt += 1
                break

    temp = [[0] * 4 for _ in range(6)]
    row = 5
    for r in range(5 - cnt, -1, -1):
        for c in range(4):
            temp[row][c] = yellow_map[r][c]
        row -= 1
    yellow_map = temp


k = int(sys.stdin.readline().rstrip())
for _ in range(k):
    t, x, y = map(int, sys.stdin.readline().rstrip().split())

    fill_red(t, x, y)
    fill_yellow(t, x, y)
    check_red()
    check_yellow()


for i in range(4):
    block_cnt += sum(red_map[i])
for i in range(6):
    block_cnt += sum(yellow_map[i])
print(score)
print(block_cnt)
