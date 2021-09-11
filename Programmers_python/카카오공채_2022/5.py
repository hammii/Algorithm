from collections import deque


def bfs(info, graph):
    visited = [False] * len(info)
    bucket = [[], []]
    q = deque()
    q.append(0)

    while q:
        cur = q.popleft()
        print(cur, 'cur')

        visited[cur] = True

        adj = False
        for next in graph[cur]:
            # print('next, ', next)
            # print(visited[next])
            if not visited[next]:
                q.append(next)
                adj = True

        if info[cur] == 0:  # 양인 경우
            bucket[0].append(cur)
        else:  # 늑대인 경우
            if len(bucket[0]) > len(bucket[1]) + 1:  # 양이 더 많은 경우
                if adj:
                    bucket[1].append(cur)

        stop = True
        for v in visited:  # 방문 안 한 곳이 한 군데라도 있다면
            if not v:
                stop = False
        if stop:
            break
        print(bucket)

    return bucket[0]


def solution(info, edges):
    graph = [[] for _ in range(len(info))]

    for s, e in edges:
        graph[s].append(e)
        graph[e].append(s)

    print(graph)
    answer = bfs(info, graph)
    print(answer)
    # for i in range(len(info)):
    #     for j in range(len(info)):
    #         print(graph[i][j], end='')
    #     print()

    return len(answer)


info = [0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0]
edges = [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6], [3, 7], [4, 8], [6, 9], [9, 10]]
print(solution(info, edges))

# 주변 애들은 무조건 queue
# 큐에서 pop한게 양이다 그러면 무조건 bucket행
# pop한게 늑대다 그러면 bucket에서 양:늑대 비교해서 bucket행
# pop한게 늑대인데 bucket에 못들어가면 바이바이
# pop한게 늑대고, bucket에 들어갈 수 있는데 pop한게 마지막 노드이면 굳이 넣어줄 필요없으니까 pass
