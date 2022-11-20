import heapq

def solution(operations):
    min_heap = []

    for o in operations:
        if o[0] == 'I':
            heapq.heappush(min_heap, int(o.split()[1]))
        elif o == 'D 1' and min_heap: # 최댓값 삭제
            min_heap.remove(max(min_heap))
        elif o == 'D -1' and min_heap:   # 최솟값 삭제
            heapq.heappop(min_heap)     

    return [max(min_heap), min_heap[0]] if min_heap else [0, 0]
