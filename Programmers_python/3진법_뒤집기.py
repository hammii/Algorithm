def solution(n):
    n3 = ''
    answer = 0
    
    while n != 1 and n != 2:
        n3 = str(n % 3) + n3
        n = n // 3
        
    n3 = str(n) + n3
    
    for i in range(len(n3)):
        answer += int(n3[i]) * (3 ** i)
        
    return answer
