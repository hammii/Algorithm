# 19:38 시작, 20:08 종료
import sys
import heapq

INF = int(1e9)

N, M, C = map(int, sys.stdin.readline().rstrip().split())
graph = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)

for _ in range(M):
    X, Y, Z = map(int, sys.stdin.readline().rstrip().split())
    graph[X].append((Y, Z))


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


dijkstra(C)

cnt = 0
max_dist = 0
for i in range(N + 1):
    if distance[i] != INF and i != C:
        cnt += 1
        max_dist = max(max_dist, distance[i])

print(cnt, max_dist)
