def solution(want, number, discount):
    answer = 0
    
    for i in range(0, len(discount)-9):
        discount_range = discount[i:i+10]
        able = True
        
        for j in range(0, len(want)):
            if discount_range.count(want[j]) < number[j]:
                able = False
                
        if able:
            answer += 1
        
    return answer
