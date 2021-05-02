import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
jewelry = []
bag = []

for _ in range(N):
    M, V = map(int, input().rstrip().split())
    jewelry.append([M, V])

for _ in range(K):
    bag.append(int(input().rstrip()))

jewelry = sorted(jewelry, key=lambda x: (-x[1], x[0]))  # 비싼 보석부터 정렬
bag = sorted(bag)  # 가벼운 가방부터 정렬

j_idx = 0
answer = 0


print(answer)
