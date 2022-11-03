from itertools import combinations

def solution(nums):
    answer = 0
    comb = list(combinations(nums, 3))
    
    for c in comb:
        is_prime = True
        
        for i in range(3, sum(c)):
            if sum(c) % i == 0:
                is_prime = False
                break
                
        if is_prime:
            answer += 1
                
    return answer
