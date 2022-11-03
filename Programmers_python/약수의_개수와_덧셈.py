def solution(left, right):
    answer = 0
    
    for num in range(left, right+1):
        d_cnt = 0
        for i in range(1, num+1):
            if num % i == 0:
                d_cnt += 1
                
        if d_cnt % 2 == 0:
            answer += num
        else:
            answer -= num
            
    return answer
