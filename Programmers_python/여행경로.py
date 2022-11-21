from collections import deque

answer = []

def dfs(tickets, visited, cur, result):
    global answer
        
    if len(list(result.split())) == len(tickets) + 1:
        answer.append(result)
        return
    
    for i in range(len(tickets)):
        if not visited[i] and tickets[i][0] == cur[1]:
            visited[i] = True
            dfs(tickets, visited, tickets[i], result+" "+tickets[i][1])
            visited[i] = False
    return
    
def solution(tickets):
    visited = [False] * len(tickets)
    tickets.sort()
    
    for i in range(len(tickets)):
        if tickets[i][0] == 'ICN':
            visited[i] = True
            dfs(tickets, visited, tickets[i], tickets[i][0]+" "+tickets[i][1])
            visited[i] = False
            
    if len(answer) >= 2:
        answer.sort()
    
    return list(answer[0].split())
