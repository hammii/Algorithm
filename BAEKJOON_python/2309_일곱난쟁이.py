import sys
import itertools

heights = [int(sys.stdin.readline().rstrip()) for i in range(9)]
heights = sorted(heights)

comb = itertools.combinations(heights, 7)

for c in comb:
    if sum(c) == 100:
        for i in c:
            print(i)
        break
