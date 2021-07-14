import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
my_list = [i for i in range(1, N + 1)]

dont_mix = [[False for col in range(201)] for row in range(201)]
for _ in range(M):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    dont_mix[a][b] = dont_mix[b][a] = True

answer = 0
for i in range(1, N - 1):
    for j in range(i + 1, N):
        if dont_mix[i][j]:
            continue

        for k in range(j + 1, N + 1):
            if dont_mix[i][k] or dont_mix[j][k]:
                continue
            answer += 1

print(answer)
