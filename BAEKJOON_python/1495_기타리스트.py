import sys

N, S, M = map(int, sys.stdin.readline().rstrip().split())
V = list(map(int, sys.stdin.readline().rstrip().split()))
V.insert(0, 0)

possible = [[False] * (M + 1) for _ in range(N + 1)]

if S + V[1] <= M:
    possible[1][S + V[1]] = True
if S - V[1] >= 0:
    possible[1][S - V[1]] = True

for i in range(2, N + 1):
    for j in range(M + 1):
        if possible[i - 1][j]:  # 전에 연주한 볼륨
            if j + V[i] <= M:
                possible[i][j + V[i]] = True
            if j - V[i] >= 0:
                possible[i][j - V[i]] = True

answer = -1
for i in range(len(possible[N])):
    if possible[N][i]:
        answer = i

print(answer)
