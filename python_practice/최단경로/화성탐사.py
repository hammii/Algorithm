# 12:25 시작, 13:28 종료
import sys
import heapq

INF = int(1e9)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dijkstra(x, y):
    q = []
    heapq.heappush(q, (graph[x][y], x, y))
    distance[x][y] = graph[x][y]

    while q:
        dist, x, y = heapq.heappop(q)

        if distance[x][y] < dist:
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:
                cost = dist + graph[nx][ny]
                if cost < distance[nx][ny]:
                    distance[nx][ny] = cost
                    heapq.heappush(q, (cost, nx, ny))


T = int(sys.stdin.readline().rstrip())

while T:
    N = int(sys.stdin.readline().rstrip())
    graph = [[] * N for _ in range(N)]
    distance = [[INF] * N for _ in range(N)]

    for i in range(N):
        graph[i] = list(map(int, sys.stdin.readline().rstrip().split()))

    dijkstra(0, 0)
    print(distance[N - 1][N - 1])
    T -= 1
