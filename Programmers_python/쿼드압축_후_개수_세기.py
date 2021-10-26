answer = [0, 0]


def comp(x, y, arr, n):
    init = arr[x][y]

    for i in range(x, x + n):
        for j in range(y, y + n):
            if arr[i][j] != init:
                half = n // 2
                comp(x, y, arr, half)
                comp(x, y + half, arr, half)
                comp(x + half, y, arr, half)
                comp(x + half, y + half, arr, half)
                return

    answer[init] += 1
    return


def solution(arr):
    comp(0, 0, arr, len(arr))
    return answer


print(solution([[1, 1, 0, 0], [1, 0, 0, 0], [1, 0, 0, 1], [1, 1, 1, 1]]))
