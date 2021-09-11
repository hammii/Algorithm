def solution(board, skill):
    answer = 0

    for s in skill:
        start = (s[1], s[2])
        end = (s[3] + 1, s[4] + 1)

        if s[0] == 1:
            for i in range(start[0], end[0]):
                for j in range(start[1], end[1]):
                    board[i][j] -= s[5]
        elif s[0] == 2:
            for i in range(start[0], end[0]):
                for j in range(start[1], end[1]):
                    board[i][j] += s[5]

        # for i in range(len(board)):
        #     for j in range(len(board[0])):
        #         print(board[i][j], end=' ')
        #     print()
        # print()

    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] > 0:
                answer += 1

    return answer


board = [[5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5]]
skill = [[1, 0, 0, 3, 4, 4], [1, 2, 0, 2, 3, 2], [2, 1, 0, 3, 1, 2], [1, 0, 1, 3, 3, 1]]

print(solution(board, skill))
