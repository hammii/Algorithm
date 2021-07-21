# 1:30 시작, 2:20 종료
import sys
from collections import deque

N = int(sys.stdin.readline().rstrip())

indegree = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]
time = [0] * (N + 1)
dp = [0] * (N + 1)

for i in range(1, N + 1):
    arr = list(map(int, sys.stdin.readline().rstrip().split()))
    time[i] = arr[0]

    for j in arr[1:-1]:
        indegree[i] += 1
        graph[j].append(i)


def topology_sort():
    result = []
    q = deque()

    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)
            dp[i] = time[i]

    while q:
        cur = q.popleft()
        result.append((cur, dp[cur]))

        for adj in graph[cur]:
            indegree[adj] -= 1
            dp[adj] = max(dp[adj], dp[cur] + time[adj])
            if indegree[adj] == 0:
                q.append(adj)
    return result


answer = topology_sort()
for i in range(N):
    print(answer[i][1])
