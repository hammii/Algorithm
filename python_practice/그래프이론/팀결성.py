# 23:30 시작, 23:36 종료
import sys


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N, M = map(int, sys.stdin.readline().rstrip().split())
parent = [0] * (N + 1)

for i in range(N):
    parent[i] = i

for _ in range(M):
    command, a, b = map(int, sys.stdin.readline().rstrip().split())
    if command == 0:  # 팀 합치기
        union_parent(parent, a, b)
    else:  # 같은 팀 여부 확인
        if find_parent(parent, a) == find_parent(parent, b):
            print("YES")
        else:
            print("NO")
