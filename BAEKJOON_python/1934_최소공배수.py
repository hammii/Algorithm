import sys
import math


def lcm(a, b):
    return int(a * b / math.gcd(a, b))


T = int(sys.stdin.readline().rstrip())
for _ in range(T):
    A, B = map(int, sys.stdin.readline().rstrip().split())
    print(lcm(A, B))
