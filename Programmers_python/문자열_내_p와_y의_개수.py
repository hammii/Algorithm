def solution(s):
    answer = True
    
    pCount = s.count('p') + s.count('P')
    yCount = s.count('y') + s.count('Y')
    
    if pCount != yCount:
        answer = False
        
    return answer
