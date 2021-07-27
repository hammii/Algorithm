# 11:06 시작, 11:43 종료
import sys
import heapq

N = int(sys.stdin.readline().rstrip())
num = [int(sys.stdin.readline().rstrip()) for _ in range(N)]

pq = []
ans = 0

for n in num:
    heapq.heappush(pq, n)

while len(pq) >= 2:
    n1 = heapq.heappop(pq)
    n2 = heapq.heappop(pq)
    ans += n1 + n2

    if len(pq) != 0:
        heapq.heappush(pq, n1 + n2)

print(ans)
