import sys
from collections import deque

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

N = int(sys.stdin.readline().rstrip())
K = int(sys.stdin.readline().rstrip())
apple = [[0] * (N + 1) for _ in range(N + 1)]

for _ in range(K):
    R, C = map(int, sys.stdin.readline().rstrip().split())
    apple[R][C] = 1

L = int(sys.stdin.readline().rstrip())
info = deque()
for _ in range(L):
    X, C = sys.stdin.readline().rstrip().split()
    info.append((int(X), C))

snake = deque()
snake.append((1, 1))
d = 1  # 바라보는 방향

time = 1
while True:
    head = snake.popleft()
    nx = head[0] + dx[d]
    ny = head[1] + dy[d]
    if nx <= 0 or ny <= 0 or nx > N or ny > N or (nx, ny) in snake:
        break

    snake.appendleft(head)
    snake.appendleft((nx, ny))

    if apple[nx][ny] == 1:
        apple[nx][ny] = 0
    elif apple[nx][ny] == 0:
        snake.pop()

    if len(info) != 0:
        if time == info[0][0]:
            if info[0][1] == 'D':
                d = (d + 1) % 4
                info.popleft()
            else:
                d = (d - 1) % 4
                info.popleft()

    time += 1

print(time)
