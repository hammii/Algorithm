# 13:55 시작, 14:12 종료
import sys
import heapq
from bisect import bisect_left

INF = int(1e9)


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, cur = heapq.heappop(q)

        if distance[cur] < dist:
            continue

        for adj in graph[cur]:
            cost = dist + adj[1]
            if cost < distance[adj[0]]:
                distance[adj[0]] = cost
                heapq.heappush(q, (cost, adj[0]))


N, M = map(int, sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)

for _ in range(M):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append((b, 1))
    graph[b].append((a, 1))

dijkstra(1)

distance[0] = 0
max_dist = max(distance)

print(bisect_left(distance, max_dist), max_dist, distance.count(max_dist))
