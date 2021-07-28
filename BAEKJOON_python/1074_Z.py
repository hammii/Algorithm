import sys


def Z(x, y, size):
    global ans
    if x == r and y == c:
        print(ans)
        return

    if x <= r < x + size and y <= c < y + size:
        Z(x, y, size // 2)
        Z(x, y + size // 2, size // 2)
        Z(x + size // 2, y, size // 2)
        Z(x + size // 2, y + size // 2, size // 2)
    else:
        ans += size * size


N, r, c = map(int, sys.stdin.readline().rstrip().split())
ans = 0

Z(0, 0, 2 ** N)
