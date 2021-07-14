import sys

R, C = map(int, sys.stdin.readline().rstrip().split())
alphabet = [list(sys.stdin.readline().rstrip()) for col in range(R)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
visited = [[False for j in range(C)] for i in range(R)]
answer = 0


def dfs(r, c, cnt, al_list):
    global answer
    flag = False

    for i in range(4):
        next_r = r + dr[i]
        next_c = c + dc[i]
        if 0 <= next_r < R and 0 <= next_c < C:
            if alphabet[next_r][next_c] not in al_list:
                flag = True
                al_list += alphabet[next_r][next_c]
                dfs(next_r, next_c, cnt + 1, al_list)
                al_list = al_list[:-1]
    if not flag:
        answer = max(answer, cnt)


dfs(0, 0, 1, alphabet[0][0])
print(answer)
