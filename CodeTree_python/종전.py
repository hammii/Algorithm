import sys

n = int(sys.stdin.readline().rstrip())
maps = [[0] * (n + 1)] + [[0] + list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]
INF = 1e9
answer = INF


def calculate_rec(x, y, d1, d2):
    temp = [[0] * (n + 1) for _ in range(n + 1)]

    temp[x][y] = 5  # 라인에 걸치는 부분 5로 설정
    for i in range(1, d1 + 1):
        temp[x + i][y - i] = 5
    for i in range(1, d2 + 1):
        temp[x + i][y + i] = 5
    for i in range(1, d2 + 1):
        temp[x + d1 + i][y - d1 + i] = 5
    for i in range(1, d1 + 1):
        temp[x + d2 + i][y + d2 - i] = 5

    R = [0] * 5  # 선거구 저장
    for r in range(1, x + d1):
        for c in range(1, y + 1):
            if temp[r][c] == 5:
                break
            R[1] += maps[r][c]
    for r in range(1, x + d2 + 1):
        for c in range(n, y, -1):
            if temp[r][c] == 5:
                break
            R[2] += maps[r][c]
    for r in range(x + d1, n + 1):
        for c in range(1, y - d1 + d2):
            if temp[r][c] == 5:
                break
            R[3] += maps[r][c]
    for r in range(x + d2 + 1, n + 1):
        for c in range(n, y - d1 + d2 - 1, -1):
            if temp[r][c] == 5:
                break
            R[4] += maps[r][c]

    R[0] = total - sum(R)
    return max(R) - min(R)


total = 0
for i in range(1, n + 1):
    total += sum(maps[i])

for x in range(1, n + 1):
    for y in range(1, n + 1):
        for d1 in range(1, n + 1):
            for d2 in range(1, n + 1):
                if x + d1 + d2 > n:
                    continue
                if y - d1 < 1:
                    continue
                if y + d2 > n:
                    continue

                answer = min(answer, calculate_rec(x, y, d1, d2))

print(answer)
