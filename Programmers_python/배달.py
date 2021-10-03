import heapq


def solution(N, road, K):
    answer = 0

    graph = [[] for _ in range(N + 1)]
    distance = [1e9] * (N + 1)

    for i in range(len(road)):
        start, end, time = road[i]
        graph[start].append((end, time))
        graph[end].append((start, time))

    q = []
    heapq.heappush(q, (0, 1))
    distance[1] = 0

    while q:
        dist, now = heapq.heappop(q)

        if dist > distance[now]:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    for i in range(1, N + 1):
        if distance[i] <= K:
            answer += 1

    return answer
