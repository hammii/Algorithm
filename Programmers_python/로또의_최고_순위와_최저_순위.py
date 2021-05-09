def solution(lottos, win_nums):
    answer = []
    same_cnt = 0
    zero_cnt = 0

    for l in lottos:
        if l == 0:
            zero_cnt += 1
        elif l in win_nums:
            same_cnt += 1

    if same_cnt + zero_cnt > 0:
        answer.append(7 - (same_cnt + zero_cnt))
    else:
        answer.append(6)
    if same_cnt > 0:
        answer.append(7 - same_cnt)
    else:
        answer.append(6)

    return answer
