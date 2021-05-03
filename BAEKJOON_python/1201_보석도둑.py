import sys
import heapq
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
jewelry = []
bags = []

for _ in range(N):
    M, V = map(int, input().rstrip().split())  # 무게와 가격
    heapq.heappush(jewelry, [M, V])

bags = [int(input().rstrip()) for _ in range(K)]
bags.sort()  # 가벼운 가방부터 정렬

answer = 0
temp_j = []

for bag in bags:
    while jewelry and jewelry[0][0] <= bag:
        heapq.heappush(temp_j, -jewelry[0][1])  # 가격과 주소 우선순위큐에 저장
        heapq.heappop(jewelry)
    if temp_j:
        answer -= heapq.heappop(temp_j)
    elif not jewelry:
        break

print(answer)
