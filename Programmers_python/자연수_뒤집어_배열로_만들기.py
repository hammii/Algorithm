def solution(n):
    answer = []
    strN = str(n)
    
    for i in range(len(strN)-1, -1, -1):
        answer.append(int(strN[i]))
        
    return answer
