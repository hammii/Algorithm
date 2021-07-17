import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
adj = [[] for _ in range(N)]
visited = [False] * N
answer = 0

for _ in range(M):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    adj[a].append(b)
    adj[b].append(a)


def dfs(cur, cnt):
    global answer
    visited[cur] = True

    if cnt == 4:
        answer = 1
        return

    for next in adj[cur]:
        if answer == 1:
            return
        if not visited[next]:
            dfs(next, cnt + 1)

    visited[cur] = False
    return


for i in range(N):
    dfs(i, 0)
    if answer == 1:
        break

print(answer)
