from collections import deque

def bfs(computers, visited, start):
    q = deque([start])
    
    while q:
        cur = q.popleft()
        for j in range(len(computers[cur])):
            if computers[cur][j] == 1 and not visited[j]:
                visited[j] = True
                q.append(j)
    
    
def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    for i in range(len(computers)):
        if not visited[i]:
            visited[i] = True
            answer += 1
            bfs(computers, visited, i)
    
    return answer
