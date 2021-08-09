import sys

V = int(sys.stdin.readline().rstrip())
graph = [[] for _ in range(V + 1)]
visited = [False] * (V + 1)
max_dist = 0
max_node = 0
answer = 0

for _ in range(V):
    line = list(map(int, sys.stdin.readline().rstrip().split()))
    line = line[:-1]  # -1 빼기
    start = line[0]
    for i in range(1, len(line), 2):
        graph[start].append((line[i], line[i + 1]))


def dfs(node, dist):
    global answer, max_dist, max_node

    if visited[node]:
        return

    if max_dist < dist:
        max_dist = dist
        max_node = node

    visited[node] = True

    for adj in graph[node]:
        dfs(adj[0], dist + adj[1])


dfs(1, 0)  # 가장 먼 정점 찾기

visited = [False] * (V + 1)
max_dist = 0
dfs(max_node, 0)  # 트리의 지름 찾기

print(max_dist)
