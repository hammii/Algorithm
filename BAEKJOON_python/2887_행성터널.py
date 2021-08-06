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


N = int(sys.stdin.readline().rstrip())
node = []
x_list = []
y_list = []
z_list = []
parent = [0] * (N + 1)

for i in range(1, N + 1):
    x, y, z = map(int, sys.stdin.readline().rstrip().split())
    x_list.append((x, i))
    y_list.append((y, i))
    z_list.append((z, i))

x_list.sort()
y_list.sort()
z_list.sort()

edges = []
for i in range(1, N):
    edges.append((abs(x_list[i][0] - x_list[i - 1][0]), x_list[i][1], x_list[i - 1][1]))
    edges.append((abs(y_list[i][0] - y_list[i - 1][0]), y_list[i][1], y_list[i - 1][1]))
    edges.append((abs(z_list[i][0] - z_list[i - 1][0]), z_list[i][1], z_list[i - 1][1]))

edges.sort()

for i in range(1, N + 1):
    parent[i] = i

answer = 0
cnt = 0
for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        answer += cost
        cnt += 1
    if cnt == N:
        break

print(answer)
