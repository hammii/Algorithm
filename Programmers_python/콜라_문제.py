def solution(a, b, n):
    answer = 0
    
    while n >= a:
        d = n // a
        n = n - a * d + b * d
        answer += b * d
        
    return answer
