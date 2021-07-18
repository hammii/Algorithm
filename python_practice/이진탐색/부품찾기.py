# 16:08 시작, 16:18 종료
import sys

N = int(sys.stdin.readline().rstrip())
n_arr = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())
m_arr = list(map(int, sys.stdin.readline().rstrip().split()))

n_arr.sort()  # O(NlogN)


def binary_search(arr, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binary_search(arr, target, start, mid - 1)
    else:
        return binary_search(arr, target, mid + 1, end)


for m in m_arr:  # O(MlogN)
    if binary_search(n_arr, m, 0, N - 1) is None:
        print("no", end=' ')
    else:
        print("yes", end=' ')
