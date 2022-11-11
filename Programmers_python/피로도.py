answer = 0

def dfs(dungeons, k, visited, cnt):
    global answer
    answer = max(answer, cnt)
    
    for i in range(len(dungeons)):
        if not visited[i] and k >= dungeons[i][0]:
            visited[i] = True
            k -= dungeons[i][1]
            dfs(dungeons, k, visited, cnt+1)
            k += dungeons[i][1]
            visited[i] = False            
    
def solution(k, dungeons):
    visited = [False] * len(dungeons)
    dfs(dungeons, k, visited, 0)
        
    return answer
