import sys

node = int(sys.stdin.readline())
edges = int(sys.stdin.readline())
virus_map = [[0 for _ in range(node + 1)] for _ in range(node + 1)]

for _ in range(edges):
    s, e = map(int, sys.stdin.readline().rstrip().split())
    virus_map[s][e] = 1
    virus_map[e][s] = 1


def bfs(virus_map, start):
    q = [start]
    visited = []

    while q:
        current = q.pop(0)
        visited.append(current)

        for i in range(len(virus_map)):
            if virus_map[current][i] == 1 and i not in visited and i not in q:
                q.append(i)

    return len(visited) - 1


print(bfs(virus_map, 1))
