def solution(n):
    answer = []

    for i in range(1, n + 1):
        answer.append([0] * n)

    row = -1
    col = 0
    cnt = 1
    for i in range(n, 0, -3):
        for j in range(0, i):
            row += 1
            answer[row][col] = cnt
            cnt += 1
        for j in range(0, i - 1):
            col += 1
            answer[row][col] = cnt
            cnt += 1
        for j in range(0, i - 2):
            row -= 1
            col -= 1
            answer[row][col] = cnt
            cnt += 1

    result = []
    for i in range(n):
        for j in range(n):
            if answer[i][j] != 0:
                result.append(answer[i][j])
    return result
