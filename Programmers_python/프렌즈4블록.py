def solution(m, n, board):
    answer = 0
    board = [list(board[i]) for i in range(len(board))]

    while True:
        flag = False
        bomb = [[False] * n for _ in range(m)]

        for i in range(m - 1):  # 같은 블록 찾기
            for j in range(n - 1):
                cur = board[i][j]
                if cur == ' ':
                    continue
                if board[i + 1][j] == board[i][j + 1] == board[i + 1][j + 1] == cur:
                    bomb[i][j] = True
                    bomb[i + 1][j] = True
                    bomb[i][j + 1] = True
                    bomb[i + 1][j + 1] = True
                    flag = True
        if not flag:
            break

        for i in range(m):  # 블록 지우기
            for j in range(n):
                if bomb[i][j]:
                    answer += 1
                    board[i][j] = ' '

        for j in range(n):  # 블록 옮기기
            for i in range(m - 2, -1, -1):
                for k in range(m - 1, i, -1):
                    if board[k][j] == ' ' and board[i][j] != ' ':
                        board[k][j] = board[i][j]
                        board[i][j] = ' '
    return answer


board = ["CCBDE", "AAADE", "AAABF", "CCBBF"]
print(solution(4, 5, board))
