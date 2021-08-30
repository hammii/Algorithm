def isValid(n, x, y):
    if 0 <= x <= n and 0 <= y <= n:
        return True
    return False


def checkBow(n, map, x, y):
    if isValid(n, x - 1, y) and map[x - 1][y][0] == 1:  # 왼쪽에 기둥이 있거나
        return True
    if isValid(n, x - 1, y + 1) and map[x - 1][y + 1][0] == 1:  # 오른쪽에 기둥이 있거나
        return True
    if (isValid(n, x, y - 1) and map[x][y - 1][1] == 1) and (
            isValid(n, x, y + 1) and map[x][y + 1][1] == 1):  # 양쪽 끝이 보인 경우
        return True
    return False


def checkColumn(n, map, x, y):
    if isValid(n, x, y) and x == 0:  # 바닥이거나
        return True
    if isValid(n, x - 1, y) and map[x - 1][y][0] == 1:  # 기둥이 있거나
        return True
    if isValid(n, x, y) and map[x][y][1] == 1:  # 오른쪽 아래에 보가 있거나
        return True
    if isValid(n, x, y - 1) and map[x][y - 1][1] == 1:  # 왼쪽 아래에 보가 있거나
        return True
    return False


def solution(n, build_frame):
    answer = []
    map = [[[0] * 2 for _ in range(n + 1)] for _ in range(n + 1)]

    for build in build_frame:
        y, x, a, b = build

        if b == 1:  # 삽입
            if a == 0 and checkColumn(n, map, x, y):  # 기둥
                map[x][y][0] += 1
            elif a == 1 and checkBow(n, map, x, y):  # 보
                map[x][y][1] += 1
        else:  # 삭제
            map[x][y][a] -= 1

            flag = False
            for i in range(n + 1):
                for j in range(n + 1):
                    if map[i][j][0] == 1:
                        if not checkColumn(n, map, i, j):
                            flag = True
                            break
                    if map[i][j][1] == 1:
                        if not checkBow(n, map, i, j):
                            flag = True
                            break
                if flag:
                    break

            if flag:
                map[x][y][a] += 1

    for i in range(n + 1):
        for j in range(n + 1):
            if map[i][j][0] == 1:
                answer.append([j, i, 0])
            if map[i][j][1] == 1:
                answer.append([j, i, 1])

    answer.sort()
    return answer
