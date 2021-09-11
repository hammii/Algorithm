max_diff = 0
answer = []


def dfs(idx, arrow, info, visited):
    global answer, max_diff

    if idx == len(info) - 1:
        apeach = 0
        ryon = 0
        if arrow > 0:
            visited[-1] = arrow

        for j in range(len(info)):
            if info[j] > 0 and info[j] > visited[j]:
                apeach += 10 - j
            if visited[j] > 0 and visited[j] > info[j]:
                ryon += 10 - j

        if ryon > apeach and (ryon - apeach) >= max_diff:
            if ryon - apeach == max_diff:
                temp_visited = visited.copy()
                temp_answer = answer.copy()
                temp_visited.reverse()
                temp_answer.reverse()
                if temp_visited > temp_answer:
                    answer = visited.copy()
                    max_diff = ryon - apeach
            else:
                answer = visited.copy()
                max_diff = ryon - apeach

        return

    for i in range(idx, len(info)):
        if arrow >= info[i] + 1:
            visited[i] = info[i] + 1
            dfs(i + 1, arrow - (info[i] + 1), info, visited)

        visited[i] = 0
        dfs(i + 1, arrow, info, visited)


def solution(n, info):
    for i in range(len(info)):
        visited = [0] * len(info)
        dfs(i, n, info, visited)

    return answer if answer else [-1]
