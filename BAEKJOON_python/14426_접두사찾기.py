import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
strings = [sys.stdin.readline().strip() for _ in range(N)]

cnt = 0
for _ in range(M):
    word = sys.stdin.readline().strip()
    for string in strings:
        if string.startswith(word):
            cnt += 1
            break

print(cnt)
