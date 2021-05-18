import sys
import collections

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y, color):
    global my_map
    dq = collections.deque()
    temp_visited = [[False] * 6 for _ in range(12)]
    dq.append([x, y])
    temp_visited[x][y] = True
    cnt = 0

    while dq:
        cur_x, cur_y = dq.popleft()
        cnt += 1

        for i in range(4):
            next_x = cur_x + dx[i]
            next_y = cur_y + dy[i]

            if 0 <= next_x < 12 and 0 <= next_y < 6:
                if my_map[next_x][next_y] == color and not temp_visited[next_x][next_y]:
                    dq.append([next_x, next_y])
                    temp_visited[next_x][next_y] = True

    if cnt >= 4:
        for i in range(12):
            for j in range(6):
                if temp_visited[i][j]:
                    my_map[i][j] = '.'
        return True

    return False


def move():
    for j in range(6):
        for i in range(11, -1, -1):
            if my_map[i][j] == '.':
                for k in range(i - 1, -1, -1):
                    if my_map[k][j] != '.':
                        my_map[i][j] = my_map[k][j]
                        my_map[k][j] = '.'
                        break


my_map = [list(map(str, input().strip())) for _ in range(12)]
answer = 0

while True:
    flag = False

    for i in range(12):
        for j in range(6):
            if my_map[i][j] != '.':
                if bfs(i, j, my_map[i][j]):
                    flag = True

    move()  # 자리 옮기기

    if not flag:
        break
    else:
        answer += 1

print(answer)
