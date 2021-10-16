from collections import deque


def solution(maps):
    q = deque()
    q.append((0, 0, 1))
    row = len(maps)
    col = len(maps[0])
    visited = [[False] * col for _ in range(row)]
    visited[0][0] = True

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        x, y, cnt = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < row and 0 <= ny < col:
                if maps[nx][ny] != 0 and not visited[nx][ny]:
                    q.append((nx, ny, cnt + 1))
                    visited[nx][ny] = True
                    maps[nx][ny] = cnt + 1

    return -1 if maps[row - 1][col - 1] == 1 else maps[row - 1][col - 1]
