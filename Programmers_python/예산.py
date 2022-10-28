def solution(d, budget):
    answer = 0
    sortedD = sorted(d)

    for i in sortedD:
        if budget >= i:
            answer += 1
            budget -= i

    return answer
