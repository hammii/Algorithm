import sys
from collections import deque

N, K = map(int, sys.stdin.readline().rstrip().split())
visited = [False] * 100001
answer = 0


def check(n):
    if n < 0 or n > 100000 or visited[n] is True:
        return False
    return True


def bfs(start):
    global answer

    q = deque()
    q.append((start, 0))
    visited[N] = True

    while q:
        cur, time = q.popleft()
        if cur == K:
            answer = time
            return

        if check(cur * 2):
            q.append((cur * 2, time))
            visited[cur * 2] = True
        if check(cur - 1):
            q.append((cur - 1, time + 1))
            visited[cur - 1] = True
        if check(cur + 1):
            q.append((cur + 1, time + 1))
            visited[cur + 1] = True


bfs(N)
print(answer)
