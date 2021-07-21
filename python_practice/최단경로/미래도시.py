# 19:13 시작, 19:31 종료
import sys

INF = int(1e9)

N, M = map(int, sys.stdin.readline().rstrip().split())
graph = [[INF] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a][b] = 1
    graph[b][a] = 1

X, K = map(int, sys.stdin.readline().rstrip().split())

for i in range(1, N + 1):
    graph[i][i] = 0

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

if graph[1][K] == INF or graph[K][X] == INF:
    print(-1)
else:
    print(graph[1][K] + graph[K][X])
