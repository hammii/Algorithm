import heapq

def solution(scoville, K):
    answer = 0
    q = []
    
    for num in scoville:
        heapq.heappush(q, num)
    
    while len(q) >= 2:
        s1 = heapq.heappop(q)
        s2 = heapq.heappop(q)
        heapq.heappush(q, s1 + s2*2)
        answer += 1
        
        min_q = heapq.heappop(q)
        if min_q >= K:
            return answer
        else:
            heapq.heappush(q, min_q)
    
    return -1
