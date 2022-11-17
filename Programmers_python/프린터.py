from collections import deque

def solution(priorities, location):
    answer = 0
    p_location = deque()
        
    for idx in range(len(priorities)):
        p_location.append([priorities[idx], idx])
        
    while p_location:
        cur = p_location.popleft()
        if p_location and cur[0] < max(p_location)[0]:
            p_location.append(cur)
        else:
            answer += 1
            if cur[1] == location:
                break
                
    return answer
