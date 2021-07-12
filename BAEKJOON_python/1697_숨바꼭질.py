import sys
from collections import deque


def check(n):
    if n < 0 or n > 100000 or visited[n]:
        return False
    return True


def BFS():
    global answer

    while q:
        cur = q.popleft()
        data = cur[0]
        depth = cur[1]

        if data == K:
            answer = depth
            break

        if check(data - 1):
            visited[data - 1] = True
            q.append([data - 1, depth + 1])
        if check(data + 1):
            visited[data + 1] = True
            q.append([data + 1, depth + 1])
        if check(data * 2):
            visited[data * 2] = True
            q.append([data * 2, depth + 1])


N, K = map(int, sys.stdin.readline().rstrip().split())

q = deque([])
q.append([N, 0])
visited = [False] * 100001
visited[N] = True
answer = 0
BFS()

print(answer)
