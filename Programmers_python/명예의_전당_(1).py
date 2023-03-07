def solution(k, score):
    answer = []
    top_k = []

    for i in range(len(score)):
        top_k.append(score[i])
        top_k = sorted(top_k, reverse=True)[:k]
        answer.append(top_k[-1])

    return answer
