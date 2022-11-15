from collections import deque

def solution(A, B):
    answer = 0

    A.sort()
    B.sort()
    
    A = deque(A)
    B = deque(B)
    
    while B:
        head_a = A.popleft()
        head_b = B.popleft()
        
        if head_a < head_b:
            answer += 1
        else:
            A.appendleft(head_a)

    return answer
