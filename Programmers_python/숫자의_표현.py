from collections import deque


def solution(n):
    answer = 0
    q = deque()

    for i in range(1, n + 1):
        q.append(i)
        if sum(q) == n:
            answer += 1
            q.popleft()
        elif sum(q) > n:
            while sum(q) > n:
                q.popleft()
            if sum(q) == n:
                answer += 1
                q.popleft()

    return answer
