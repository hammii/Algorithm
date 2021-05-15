import sys
from collections import deque
input = sys.stdin.readline

test = int(input().rstrip())
answer = []

for _ in range(test):
    N, find = map(int, input().rstrip().split())
    dq = deque(map(int, input().rstrip().split()))

    cnt = 1
    while True:
        first = dq[0]
        if first == max(dq):    # 우선순위가 높은 경우
            if find == 0:
                answer.append(cnt)
                break
            else:
                dq.popleft()
                find -= 1
                cnt += 1
        else:   # 우선순위가 낮은 경우
            if find == 0:
                find = len(dq) - 1
            else:
                find -= 1

            dq.popleft()
            dq.append(first)

for a in answer:
    print(a)
