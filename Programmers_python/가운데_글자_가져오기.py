def solution(s):
    cnt = len(s)    
    
    if cnt % 2 == 1:
        return s[cnt//2]
    else:
        return s[cnt//2-1]+s[cnt//2]