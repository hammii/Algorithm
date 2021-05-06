def solution(board, moves):
    answer = 0
    selected = []

    for move in moves:
        for row in range(len(board)):
            if board[row][move - 1] > 0:
                if len(selected) > 0 and selected[-1] == board[row][move - 1]:
                    answer += 2
                    del selected[-1]
                else:
                    selected.append(board[row][move - 1])
                board[row][move - 1] = 0
                break

    return answer
