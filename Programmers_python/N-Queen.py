answer = 0


def possible(row, maps):
    for i in range(row):
        if maps[i] == maps[row] or abs(row - i) == abs(maps[row] - maps[i]):
            return False
    return True


def nQueen(row, maps, n):
    global answer
    if row == n:
        answer += 1
    else:
        for col in range(n):
            maps[row] = col
            if possible(row, maps):
                nQueen(row + 1, maps, n)


def solution(n):
    maps = [0] * n ** 2
    nQueen(0, maps, n)
    return answer


print(solution(4))
