import sys
from collections import deque
import heapq

R, C = map(int, sys.stdin.readline().rstrip().split())
my_map = [list(sys.stdin.readline().rstrip()) for _ in range(R)]
N = int(sys.stdin.readline().rstrip())
heights = list(map(int, sys.stdin.readline().rstrip().split()))
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    q = deque()
    q.append((x, y))
    visited = [[False for _ in range(C)] for _ in range(R)]
    visited[x][y] = True
    flag = False
    hq = []

    while q:
        x, y = q.popleft()
        heapq.heappush(hq, (-x, y))
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < R and 0 <= ny < C:
                if my_map[nx][ny] == 'x' and not visited[nx][ny]:
                    if nx == R - 1:  # 땅인 경우
                        flag = True
                        break
                    q.append((nx, ny))
                    visited[nx][ny] = True
        if flag:
            break

    if flag:
        return None
    else:
        return hq


def move(q, distance):
    while q:
        cur = heapq.heappop(q)
        x = -cur[0]
        y = cur[1]
        my_map[x + distance][y] = 'x'
        my_map[x][y] = '.'


for i in range(N):
    attack_x = R - heights[i]
    attack_y = 0

    if i % 2 == 0:  # 공격 방향: 0이면 ->, 1이면 <-
        for col in range(0, C):
            if my_map[attack_x][col] == 'x':
                attack_y = col
                break
    else:
        for col in range(C - 1, -1, -1):
            if my_map[attack_x][col] == 'x':
                attack_y = col
                break

    my_map[attack_x][attack_y] = '.'
    for k in range(4):  # 공격당한 좌표 상,하,좌,우 살피기
        nx = attack_x + dx[k]
        ny = attack_y + dy[k]
        if 0 <= nx < R and 0 <= ny < C and my_map[nx][ny] == 'x':
            replace_q = bfs(nx, ny)
            if replace_q is not None:   # 땅과 떨어진 클러스터 확인
                min_dist = C

                for idx in range(len(replace_q)):
                    height = -replace_q[idx][0]
                    col = replace_q[idx][1]
                    temp_height = height + 1

                    while True:  # 떨어질 거리 구하기
                        if my_map[temp_height][col] == 'x' and (-temp_height, col) not in replace_q:
                            min_dist = min(min_dist, temp_height - 1 - height)
                            break
                        if temp_height == R - 1 and (-temp_height, col) not in replace_q:
                            min_dist = min(min_dist, temp_height - height)
                            break

                        temp_height += 1
                move(replace_q, min_dist)

for row in range(R):
    print(''.join(my_map[row]))
