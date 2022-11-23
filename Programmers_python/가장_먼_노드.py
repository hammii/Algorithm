from collections import deque, defaultdict

def bfs(n, adj):
    visited = [False] * (n+1)
    min_dist = [1e9] * (n+1)
    visited[1] = True
    min_dist[1] = 0
    q = deque([1])
    
    while q:
        cur = q.popleft()
        
        for a in adj[cur]:    
            if not visited[a]:
                q.append(a)    
                visited[a] = True
                min_dist[a] = min_dist[cur]+1

    max_dist = max(min_dist[1:])
    return min_dist.count(max_dist)
    
def solution(n, edge):
    edge.sort()
    
    adj = defaultdict(list)
    for start, end in edge:
        adj[start].append(end)
        adj[end].append(start)
        
    return bfs(n, adj)
