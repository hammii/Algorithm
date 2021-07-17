import sys
from itertools import combinations

N, K = map(int, sys.stdin.readline().rstrip().split())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

comb = list(combinations(arr, 3))
comb_sum = set()
for c in comb:
    comb_sum.add(sum(c))

comb_sum = sorted(list(comb_sum), reverse=True)
print(comb_sum[K-1])
