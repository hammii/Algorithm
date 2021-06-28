import sys

N = sys.stdin.readline().rstrip()
A = list(map(int, sys.stdin.readline().rstrip().split()))
cal = list(map(int, sys.stdin.readline().rstrip().split()))
my_max = -1000000000
my_min = 1000000000


def dfs(index, cur, plus, minus, mul, div):
    global my_max, my_min
    if index == len(A):
        my_max = max(my_max, cur)
        my_min = min(my_min, cur)
        return

    if plus > 0:
        dfs(index + 1, cur + A[index], plus - 1, minus, mul, div)
    if minus > 0:
        dfs(index + 1, cur - A[index], plus, minus - 1, mul, div)
    if mul > 0:
        dfs(index + 1, cur * A[index], plus, minus, mul - 1, div)
    if div > 0:
        if cur < 0:
            cur = -(-cur // A[index])
            dfs(index + 1, cur, plus, minus, mul, div - 1)
        else:
            dfs(index + 1, cur // A[index], plus, minus, mul, div - 1)


dfs(1, A[0], cal[0], cal[1], cal[2], cal[3])
print(my_max)
print(my_min)
