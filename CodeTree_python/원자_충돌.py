import sys

n, m, k = map(int, sys.stdin.readline().rstrip().split())
maps = [[[] for _ in range(n + 1)] for _ in range(n + 1)]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, - 1, - 1]


def move_atoms(maps):
    temp = [[[] for _ in range(n + 1)] for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if maps[i][j]:
                for atom in maps[i][j]:
                    m, s, d = atom[0], atom[1], atom[2]
                    move = s % n
                    nx = i + dx[d] * move
                    ny = j + dy[d] * move
                    if nx > n: nx -= n
                    if ny > n: ny -= n
                    if nx < 1: nx += n
                    if ny < 1: ny += n
                    temp[nx][ny].append((m, s, d))
    return temp


def combine_atoms(maps):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if len(maps[i][j]) >= 2:
                m_sum, s_sum = 0, 0
                odd, even = True, True
                for atom in maps[i][j]:
                    m_sum += atom[0]
                    s_sum += atom[1]
                    if atom[2] % 2 == 0:
                        odd = False
                    else:
                        even = False
                m = m_sum // 5
                s = s_sum // len(maps[i][j])
                start = 0 if odd is True or even is True else 1  # 방향들이 같으면 상하좌우(0), 다르면 대각선(1)
                if m == 0:
                    maps[i][j] = []
                    continue

                arr = []
                for d in range(start, 8, 2):
                    arr.append((m, s, d))
                maps[i][j] = arr
    return maps


for _ in range(m):
    x, y, m, s, d = map(int, sys.stdin.readline().rstrip().split())
    maps[x][y].append((m, s, d))

for _ in range(k):
    maps = move_atoms(maps)
    maps = combine_atoms(maps)

answer = 0
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if maps[i][j]:
            for atom in maps[i][j]:
                answer += atom[0]

print(answer)
