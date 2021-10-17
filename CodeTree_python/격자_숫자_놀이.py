import sys

r, c, k = map(int, sys.stdin.readline().rstrip().split())
A = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(3)]
time = 0


def sort_rows(row, col):
    count_list = [[] for _ in range(row)]
    max_col = 0

    for i in range(row):
        count_dict = dict()
        for j in range(col):
            if A[i][j] == 0: continue
            if A[i][j] in count_dict:
                count_dict[A[i][j]] += 1
            else:
                count_dict[A[i][j]] = 1

        sorted_list = list(sorted(count_dict.items(), key=lambda x: (x[1], x[0])))

        for item in sorted_list:
            count_list[i].append(item[0])
            count_list[i].append(item[1])
            max_col = max(max_col, len(count_list[i]))

    next_maps = [[0] * max_col for _ in range(row)]
    for i in range(len(count_list)):
        for j in range(len(count_list[i])):
            next_maps[i][j] = count_list[i][j]

    return next_maps


def sort_cols(row, col):
    count_list = [[] for _ in range(col)]
    max_row = 0

    for j in range(col):
        count_dict = dict()
        for i in range(row):
            if A[i][j] == 0: continue
            if A[i][j] in count_dict:
                count_dict[A[i][j]] += 1
            else:
                count_dict[A[i][j]] = 1

        sorted_list = list(sorted(count_dict.items(), key=lambda x: (x[1], x[0])))

        for item in sorted_list:
            count_list[j].append(item[0])
            count_list[j].append(item[1])
            max_row = max(max_row, len(count_list[j]))

    next_maps = [[0] * col for _ in range(max_row)]
    for i in range(len(count_list)):
        for j in range(len(count_list[i])):
            next_maps[j][i] = count_list[i][j]

    return next_maps


while True:
    row, col = len(A), len(A[0])
    if (row >= r and col >= c) and (A[r - 1][c - 1] == k):
        break
    if time > 100:
        time = -1
        break

    if row >= col:
        A = sort_rows(row, col)
    else:
        A = sort_cols(row, col)
    time += 1

print(time)
