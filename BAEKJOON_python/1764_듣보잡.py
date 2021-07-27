import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
listen = []
answer = []

for _ in range(N + M):
    name = sys.stdin.readline().rstrip()
    listen.append(name)

listen.sort()

i = 0
while i < N + M - 1:
    if listen[i] == listen[i + 1]:
        answer.append(listen[i])
        i += 2
    else:
        i += 1

print(len(answer))
for a in answer:
    print(a)
