from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(place, x, y):
    visited = [[False] * 5 for _ in range(5)]
    q = deque()
    q.append((x, y, 0))
    visited[x][y] = True

    while q:
        x, y, cost = q.popleft()
        if cost == 2:
            continue
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < 5 and 0 <= ny < 5:
                if visited[nx][ny]:
                    continue
                if place[nx][ny] == 'P':
                    return False
                if place[nx][ny] == 'O':
                    q.append((nx, ny, cost + 1))
                    visited[nx][ny] = True
    return True


def solution(places):
    answer = []

    for place in places:
        p = [list(place[i]) for i in range(5)]
        flag = True

        for i in range(5):
            for j in range(5):
                if p[i][j] == 'P':
                    if not bfs(p, i, j):  # 거리두기 안 지켰을 경우
                        flag = False
                        break
            if not flag:
                break

        if flag:
            answer.append(1)
        else:
            answer.append(0)

    return answer
