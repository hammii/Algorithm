from collections import defaultdict


def dfs(tree, visited, start):
    global cnt

    visited.append(start)
    cnt += 1

    for i in tree[start]:
        if i not in visited:
            dfs(tree, visited, i)


def solution(n, wires):
    global cnt
    answer = int(1e9)
    tree = defaultdict(list)
    for a, b in wires:
        tree[a].append(b)
        tree[b].append(a)

    for a, b in wires:
        tree[a].remove(b)
        tree[b].remove(a)
        cnt = 0
        dfs(tree, [], 1)
        answer = min(answer, abs(cnt - (n - cnt)))
        tree[a].append(b)
        tree[b].append(a)

    return answer
