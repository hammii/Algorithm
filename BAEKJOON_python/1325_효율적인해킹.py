import sys
from collections import deque


def bfs(start):
    q = deque([start])
    visited = [0] * (N + 1)
    visited[start] = 1

    while q:
        cur = q.popleft()
        for i in graph[cur]:
            if not visited[i]:
                q.append(i)
                visited[i] = 1

    return visited.count(1)


N, M = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]
result = []

for _ in range(M):  # 입력
    e, s = map(int, sys.stdin.readline().split())
    graph[s].append(e)

for i in range(1, N + 1):  # bfs 실행
    result.append(bfs(i))

max_cnt = max(result)
for i in range(N):
    if result[i] == max_cnt:
        print(i + 1, end=' ')
