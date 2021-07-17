import sys
import math

N = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))


def reverse(x):
    x_str = str(x)
    x_str = x_str[::-1]
    return int(x_str)


def isPrime(x):
    if x == 1:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True


for a in arr:
    a = reverse(a)
    if isPrime(a):
        print(a, end=' ')
