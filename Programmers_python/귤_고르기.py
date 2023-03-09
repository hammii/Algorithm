from collections import Counter

def solution(k, tangerine):
    answer = 0

    counter = Counter(tangerine)
    items = sorted(counter.items(), key=lambda x:x[1], reverse=True)

    for key, value in items:
        if k <= 0:
            break            
        k -= value
        answer += 1

    return answer
