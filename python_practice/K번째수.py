import sys

T = int(sys.stdin.readline().rstrip())

for test in range(T):
    N, s, e, k = map(int, sys.stdin.readline().rstrip().split())
    arr = list(map(int, sys.stdin.readline().rstrip().split()))
    arr = arr[s - 1:e]
    arr.sort()
    print(f'#{test + 1} {arr[k - 1]}')
