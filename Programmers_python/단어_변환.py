answer = 1e9

def dfs(words, visited, word, cnt, target):
    global answer
    
    if word == target:
        answer = min(answer, cnt)
        return
    
    for i in range(len(words)):
        if visited[i]:
            continue
            
        diff = 0    
        for j in range(len(word)):
            if word[j] != words[i][j]:
                diff += 1
        if diff == 1:
            visited[i] = True
            dfs(words, visited, words[i], cnt+1, target)
            visited[i] = False
            
    return

def solution(begin, target, words):
    visited = [False] * len(words)
    dfs(words, visited, begin, 0, target)
    
    return answer if answer != 1e9 else 0
