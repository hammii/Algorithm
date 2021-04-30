import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
board = [[0 for i in range(N + 1)] for j in range(N + 1)]
visited = [False for _ in range(N + 1)]
answer = 0


def dfs(idx):
    visited[idx] = True

    for i in range(1, N + 1):
        if board[idx][i] == 1 and visited[i] is False:
            dfs(i)


for _ in range(M):
    start, end = map(int, sys.stdin.readline().rstrip().split())
    board[start][end] = 1
    board[end][start] = 1

for i in range(1, N + 1):
    if visited[i] is False:
        answer += 1
        dfs(i)

print(answer)
