import sys

N = int(sys.stdin.readline().rstrip())
houses = list(map(int, sys.stdin.readline().rstrip().split()))

houses.sort()

print(houses[(len(houses) - 1) // 2])
