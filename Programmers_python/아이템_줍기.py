answer = 1e9

def dfs(my_map, visited, cur_x, cur_y, end_x, end_y, cnt):
    global answer
    dx = [-1,0,1,0]
    dy = [0,-1,0,1]
    
    if cur_x == end_x and cur_y == end_y:
        answer = min(answer, cnt//2)
        return
    
    for i in range(4):
        nx = cur_x + dx[i]
        ny = cur_y + dy[i]
        
        if 0<=nx<=101 and 0<=ny<=101 and my_map[nx][ny] == 1 and not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(my_map, visited, nx, ny, end_x, end_y, cnt+1)
            visited[nx][ny] = False

    return
    
    
def solution(rectangle, characterX, characterY, itemX, itemY):
    my_map = [[0] * 102 for _ in range(102)]
    visited = [[False] * 102 for _ in range(102)]
    
    for r in rectangle:
        start_x, start_y, end_x, end_y = r[0]*2, r[1]*2, r[2]*2, r[3]*2
        
        for x in range(start_x, end_x+1):
            for y in range(start_y, end_y+1):
                if my_map[x][y] == -1:
                    continue
                    
                if x == start_x or x == end_x:
                    my_map[x][y] = 1
                elif y == start_y or y == end_y:
                    my_map[x][y] = 1
                else:
                    my_map[x][y] = -1
    
    visited[characterX*2][characterY*2] = True
    dfs(my_map, visited, characterX*2, characterY*2, itemX*2, itemY*2, 0)
    
    return answer
