import sys

INF = int(1e9)

n, m, r = map(int, sys.stdin.readline().rstrip().split())
t = list(map(int, sys.stdin.readline().rstrip().split()))
t.insert(0, 0)
graph = [[INF] * (n + 1) for _ in range(n + 1)]

for _ in range(r):
    a, b, l = map(int, sys.stdin.readline().rstrip().split())
    graph[a][b] = l
    graph[b][a] = l

for a in range(1, n + 1):  # 자기 자신으로 가는 비용 0
    for b in range(1, n + 1):
        if a == b:
            graph[a][b] = 0

for k in range(1, n + 1):  # 플로이드 워셜
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

answer = 0
for a in range(1, n + 1):
    sum = 0
    for b in range(1, n + 1):
        if graph[a][b] <= m:  # 수색범위 내에 있으면
            sum += t[b]  # 아이템 획득

    answer = max(answer, sum)

print(answer)
