import sys
from collections import deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

M, N = map(int, sys.stdin.readline().rstrip().split())
arr = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
queue = deque()
answer = 0


def bfs(q):
    global arr
    visited = [[False] * M for _ in range(N)]
    for point in q:
        visited[point[0]][point[1]] = True
    cnt = 0

    while q:
        start_q = deque(q)
        q.clear()
        flag = False

        while start_q:
            cur = start_q.popleft()
            r = cur[0]
            c = cur[1]
            for i in range(4):
                next_r = r + dr[i]
                next_c = c + dc[i]
                if 0 <= next_r < N and 0 <= next_c < M:
                    if arr[next_r][next_c] == 0 and not visited[next_r][next_c]:
                        q.append((next_r, next_c))
                        arr[next_r][next_c] = 1
                        visited[next_r][next_c] = True
                        flag = True
        if flag:
            cnt += 1
    return cnt


one_cnt = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            queue.append((i, j))
            one_cnt += 1

if one_cnt == M * N:  # 처음에 모든 토마토 1이면 0 출력
    print(answer)
else:
    answer = bfs(queue)

    breaker = False
    for i in range(N):  # 다 훑었는데 익지 못하면 1 출력
        for j in range(M):
            if arr[i][j] == 0:
                print(-1)
                breaker = True
                break
        if breaker:
            break
    if not breaker:
        print(answer)
