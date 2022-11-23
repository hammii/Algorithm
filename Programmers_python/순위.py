INF = int(1e9)

def solution(n, results):
    answer = 0
    game = [[INF] * (n+1) for _ in range(n+1)]
    ranking = [True] * (n+1)

    for i in range(1, n+1):
        for j in range(1, n+1):
            if i==j:
                game[i][j] = 0
                
    for winner, loser in results:
         game[winner][loser] = 1
                
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                game[i][j] = min(game[i][j], game[i][k]+game[k][j])
    
    for i in range(1, n+1):
        able = True
        for j in range(1, n+1):
            if game[i][j] == INF and game[j][i] == INF:
                able = False
                break
        ranking[i] = able
            
    return ranking[1:].count(True)
