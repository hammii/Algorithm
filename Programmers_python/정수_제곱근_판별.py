import math
    
def solution(n):
    sqrtN = math.sqrt(n)
    
    if sqrtN - int(sqrtN) == 0:
        return (sqrtN + 1) ** 2
    else:
        return -1
