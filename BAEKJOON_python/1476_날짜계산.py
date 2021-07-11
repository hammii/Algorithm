import sys

E, S, M = map(int, sys.stdin.readline().rstrip().split())
year = 1
answer = 0

while True:
    if (year - E) % 15 == 0 and (year - S) % 28 == 0 and (year - M) % 19 == 0:
        answer = year
        break
    year += 1

print(answer)
