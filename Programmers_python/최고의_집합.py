def solution(n, s):
    answer = []
    
    if n > s:
        return [-1]
    
    for _ in range(n):
        answer.append(s // n)
        s -= s // n
        n -= 1
        
    return answer
