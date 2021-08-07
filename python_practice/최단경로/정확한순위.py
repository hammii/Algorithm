# 0:50 시작, 1:10 종료
import sys

INF = int(1e9)
N, M = map(int, sys.stdin.readline().rstrip().split())
graph = [[INF] * (N + 1) for _ in range(N + 1)]

for i in range(N + 1):
    graph[i][i] = 0

for _ in range(M):
    A, B = map(int, sys.stdin.readline().rstrip().split())
    graph[A][B] = -1
    graph[B][A] = 1

for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            if graph[a][k] == graph[k][b] and graph[a][k] != 0 and graph[a][k] != INF:
                graph[a][b] = graph[a][k]

answer = 0
for i in range(1, N + 1):
    flag = False
    for j in range(1, N + 1):
        if graph[i][j] == INF:
            flag = True
            break
    if not flag:
        answer += 1

print(answer)
