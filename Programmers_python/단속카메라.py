def solution(routes):
    routes.sort()
    out = routes[0][1]
    answer = 1
        
    for i in range(1, len(routes)):
        if routes[i][1] < out:
            out = routes[i][1]
        if routes[i][0] > out:
            out = routes[i][1]
            answer += 1
        
    return answer
