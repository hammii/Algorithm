import heapq

def solution(n, works):
    sorted_works = []
    answer = 0

    for value in works:
        heapq.heappush(sorted_works, -value)
            
    for i in range(n):
        value = heapq.heappop(sorted_works) + 1
        heapq.heappush(sorted_works, value)
        if value > 0:
            return 0
    
    for value in sorted_works:
        answer += (-value) ** 2
        
    return answer
