def rotation(start_x, start_y, end_x, end_y):
    global my_map
    arr = []

    temp = my_map[start_x][start_y]
    arr.append(temp)
    for row in range(start_x, end_x):
        my_map[row][start_y] = my_map[row + 1][start_y]
        arr.append(my_map[row][start_y])
    for col in range(start_y, end_y):
        my_map[end_x][col] = my_map[end_x][col + 1]
        arr.append(my_map[end_x][col])
    for row in range(end_x, start_x, -1):
        my_map[row][end_y] = my_map[row - 1][end_y]
        arr.append(my_map[row][end_y])
    for col in range(end_y, start_y, -1):
        my_map[start_x][col] = my_map[start_x][col - 1]
        arr.append(my_map[start_x][col])
    my_map[start_x][start_y + 1] = temp

    return min(arr)


def solution(rows, columns, queries):
    global my_map
    my_map = [[0] * (columns + 1) for _ in range(rows + 1)]

    i = 1
    for row in range(1, rows + 1):
        for col in range(1, columns + 1):
            my_map[row][col] = i
            i += 1

    answer = []
    for q in queries:
        answer.append(rotation(q[0], q[1], q[2], q[3]))  # 최소값

    return answer


print(solution(6, 6, [[2, 2, 5, 4], [3, 3, 6, 6], [5, 1, 6, 3]]))
