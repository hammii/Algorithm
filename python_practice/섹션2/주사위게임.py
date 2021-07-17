import sys
from collections import Counter

N = int(sys.stdin.readline().rstrip())
arr = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N)]
answer = []

for a in arr: 
    counter = dict(Counter(a))
    if max(counter.values()) == 3:
        num = (int(list(counter.keys())[0]))
        answer.append(10000 + num * 1000)
    elif max(counter.values()) == 2:
        num = 0
        for key, values in counter.items():
            if values == 2:
                num = key
        answer.append(1000 + num * 100)
    else:
        num = max(a)
        answer.append(num * 100)

print(max(answer))
