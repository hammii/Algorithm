def solution(a, b):
    answer = 0
    for idx in range(len(a)):
        answer += a[idx] * b[idx]
    return answer
