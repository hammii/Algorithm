def solution(n, s, a, b, fares):
    INF = int(1e9)
    answer = INF
    graph = [[INF] * (n + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        graph[i][i] = 0

    for f in fares:
        start, end, cost = f
        graph[start][end] = cost
        graph[end][start] = cost

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

    for k in range(n + 1):
        answer = min(answer, graph[s][k] + graph[k][a] + graph[k][b])
        print(a, b, k)
    return answer
