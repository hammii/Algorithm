import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
line = sys.stdin.readline().rstrip()
true_n = line[0]
true_people = []  # 진실을 아는 사람

if true_n != 1:
    true_people = list(map(int, line.split()))
    true_people = true_people[1:]

party_people = [[] for _ in range(M)]  # 파티에 오는 사람
for i in range(M):
    line = sys.stdin.readline().rstrip()

    party_n = line[0]
    if party_n != 0:
        people = list(map(int, line.split()))
        party_people[i] = people[1:]


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


parent = [0] * (N + 1)
for i in range(1, N + 1):
    parent[i] = i

for party in party_people:  # 부모 같게 해주기
    for i in range(len(party) - 1):
        for j in range(i + 1, len(party)):
            union_parent(parent, party[i], party[j])

answer = 0
true_people_parent = []
for i in range(len(true_people)):   # 진실을 아는 그룹
    true_people_parent.append(find_parent(parent, true_people[i]))

for party in party_people:  # 부모가 true_people_parent에 속한다면 count 하지 않기
    flag = False
    for i in range(len(party)):
        if find_parent(parent, party[i]) in true_people_parent:
            flag = True
            break
    if not flag:
        answer += 1

print(answer)
