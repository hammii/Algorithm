def solution(a, b):
    max_ab = max(a,b)
    min_ab = min(a,b)
    return sum(range(min_ab, max_ab+1))