from collections import deque


def solution(cacheSize, cities):
    answer = 0
    q = deque()

    if cacheSize == 0:
        return len(cities) * 5

    for city in cities:
        city = city.upper()
        if city in q:  # cache hit
            q.remove(city)
            answer += 1
            q.append(city)
        else:  # cache miss
            if len(q) >= cacheSize:
                q.popleft()
            answer += 5
            q.append(city)
    return answer
