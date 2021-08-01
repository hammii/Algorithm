import sys
from collections import deque

N, M, K, X = map(int, sys.stdin.readline().rstrip().split())
adj = [[] for _ in range(N + 1)]
visited = [False] * (N + 1)
answer = []

for _ in range(M):
    A, B = map(int, sys.stdin.readline().rstrip().split())
    adj[A].append(B)


def bfs(x, dist):
    q = deque()
    q.append((x, dist))
    visited[x] = True

    while q:
        cur, dist = q.popleft()
        if dist == K:
            answer.append(cur)
            continue

        for a in adj[cur]:
            if not visited[a]:
                q.append((a, dist + 1))
                visited[a] = True


bfs(X, 0)
answer.sort()

if len(answer) == 0:
    print(-1)
else:
    for a in answer:
        print(a)
