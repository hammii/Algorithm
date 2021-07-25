import sys

N = list(map(int, list(sys.stdin.readline().rstrip())))

length = len(N) // 2
left = sum(N[:length])
right = sum(N[length:])

if left == right:
    print("LUCKY")
else:
    print("READY")
