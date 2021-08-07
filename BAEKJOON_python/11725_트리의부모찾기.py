import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(N + 1)]
parent = [0] * (N + 1)

for _ in range(N - 1):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs(start):
    q = deque()
    q.append(start)

    while q:
        cur = q.popleft()
        for adj in graph[cur]:
            if parent[adj] != 0:
                continue
            parent[adj] = cur
            q.append(adj)


bfs(1)

for i in range(2, N + 1):
    print(parent[i])
