import sys
import heapq

INF = int(1e9)

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())
adj = [[] for _ in range(N + 1)]
distance = [INF] * (N + 1)

for _ in range(M):
    a, b, c = map(int, sys.stdin.readline().rstrip().split())
    adj[a].append((b, c))

start, end = map(int, sys.stdin.readline().rstrip().split())


def dijkstra(start):
    q = []

    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        cur_dist, cur = heapq.heappop(q)
        if distance[cur] < cur_dist:
            continue

        for a in adj[cur]:  # 인접한 노드 하나씩 확인
            cost = cur_dist + a[1]
            if cost < distance[a[0]]:
                distance[a[0]] = cost
                heapq.heappush(q, (cost, a[0]))


dijkstra(start)

print(distance[end])
