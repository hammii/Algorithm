import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().rstrip().split())
arr = [i for i in range(1, N + 1)]

answer = list(combinations(arr, M))

for a in answer:
    for num in a:
        print(num, end=' ')
    print()
