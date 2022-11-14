alpha = ['A', 'E', 'I', 'O', 'U']
cnt = 0
answer = 0

def dfs(word, string):
    global cnt, answer
    cnt += 1

    if word == string:
        answer = cnt
        return
    
    if len(string) >= 5:
        return
    
    for a in alpha:    
        dfs(word, string+a)
        
    return

def solution(word):    
    for a in alpha:
        dfs(word, a)
    
    return answer
