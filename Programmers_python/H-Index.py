def solution(citations):
    answer = 0
    
    citations.sort()
    for i in range(len(citations)-1, -1, -1):
        if len(citations)-i <= citations[i]:
            answer = len(citations)-i
    
    return answer
