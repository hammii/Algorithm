answer = 0

def dfs(numbers, idx, total, target):
    global answer
    
    if idx == len(numbers):
        if total == target:
            answer += 1
        return 
        
    dfs(numbers, idx+1, total + numbers[idx], target)
    dfs(numbers, idx+1, total - numbers[idx], target)
    
def solution(numbers, target):
    dfs(numbers, 0, 0, target)
    
    return answer
