import sys

N, M = map(int, sys.stdin.readline().rstrip().split())

strings = []
for i in range(N):
    strings.append(input())

cnt = 0
for _ in range(M):
    word = input()
    for string in strings:
        if string.startswith(word):
            cnt += 1
            break

print(cnt)
