import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = [[0]*M for _ in range(N)]

print(arr)