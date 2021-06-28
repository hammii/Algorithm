import sys
import itertools

N = sys.stdin.readline().rstrip()
num = list(map(int, sys.stdin.readline().rstrip().split()))
answer = 0

perm = list(itertools.permutations(num))
for p in perm:
    sum = 0
    for idx in range(0, len(p) - 1):
        sum += abs(p[idx] - p[idx + 1])
    if answer < sum:
        answer = sum

print(answer)
