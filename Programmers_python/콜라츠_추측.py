def solution(num):
    answer = 0
    
    while num != 1:
        answer += 1
        
        if num % 2 == 0:
            num = num // 2
        else:
            num = num * 3 + 1   
        
        if num == 0:
            return 0
        if answer == 500:
            return -1
            
    return answer
