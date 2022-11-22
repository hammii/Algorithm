from collections import deque

def solution(queue1, queue2):
    total = (sum(queue1) + sum(queue2)) // 2
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    sum_1 = sum(queue1)
    sum_2 = sum(queue2)
    cnt = 0
    
    while True:
        if len(queue1)==0 or len(queue2)==0 or cnt==600000:
            cnt = -1
            break
        if sum_1 == sum_2:
            break
        if sum_1 > sum_2:
            cur = queue1.popleft()
            queue2.append(cur)
            sum_2 += cur
            sum_1 -= cur
        else:
            cur = queue2.popleft()
            queue1.append(cur)
            sum_1 += cur
            sum_2 -= cur
        cnt += 1
        
    return cnt
