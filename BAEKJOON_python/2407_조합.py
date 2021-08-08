import sys
import math

n, m = map(int, sys.stdin.readline().rstrip().split())
sum = math.factorial(n) // math.factorial(n - m) // math.factorial(m)

print(sum)
