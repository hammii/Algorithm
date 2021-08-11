import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
max_dist = 0
max_node = 0

for _ in range(n - 1):
    a, b, c = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append((b, c))
    graph[b].append((a, c))


def bfs(start):
    global max_node, max_dist
    q = deque()
    q.append((start, 0))
    visited[start] = True

    while q:
        cur, dist = q.popleft()
        if dist > max_dist:
            max_node, max_dist = cur, dist

        for adj in graph[cur]:
            if not visited[adj[0]]:
                q.append((adj[0], dist + adj[1]))
                visited[adj[0]] = True


bfs(1)

visited = [False] * (n + 1)
max_dist = 0
bfs(max_node)

print(max_dist)
