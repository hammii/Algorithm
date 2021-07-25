import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    q = []

    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i + 1))

    pre_time = 0
    while k - (q[0][0] - pre_time) * len(q) >= 0:
        top = heapq.heappop(q)[0]  # 최소 시간
        k -= (top - pre_time) * (len(q) + 1)
        pre_time = top

    q = sorted(q, key=lambda x: x[1])
    return q[k % len(q)][1]