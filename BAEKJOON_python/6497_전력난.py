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


while True:
    m, n = map(int, sys.stdin.readline().rstrip().split())
    if m == 0 and n == 0:
        break

    parent = [0] * m
    edges = []
    sum_edges = 0
    result = 0

    for i in range(m):
        parent[i] = i

    for _ in range(n):
        x, y, z = map(int, sys.stdin.readline().rstrip().split())
        edges.append((z, x, y))
        sum_edges += z

    edges.sort()

    for edge in edges:
        cost, a, b = edge
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            result += cost

    print(sum_edges - result)
