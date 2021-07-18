# 16:51 시작, 17:15 종료
import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
arr = list(map(int, sys.stdin.readline().rstrip().split()))


def binary_search(arr, target, start, end):
    if start > end:
        return end
    mid = (start + end) // 2

    cut = 0
    for a in arr:
        if a > mid:
            cut += (a - mid)

    if cut == target:
        return mid
    elif cut > target:
        return binary_search(arr, target, mid + 1, end)
    else:
        return binary_search(arr, target, start, mid - 1)


arr.sort()
print(binary_search(arr, M, 0, max(arr)))
