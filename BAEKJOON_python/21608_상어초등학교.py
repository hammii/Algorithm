import sys

N = int(sys.stdin.readline().rstrip())
student_list = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(N ** 2)]
maps = [[0] * (N + 1) for _ in range(N + 1)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
adj_dict = dict()

for idx in range(0, N ** 2):
    if idx == 0:
        maps[2][2] = student_list[0][0]
        adj_dict[student_list[0][0]] = student_list[0][1:]
        continue

    student_idx = student_list[idx][0]
    like_list = student_list[idx][1:]
    adj_dict[student_idx] = like_list
    x, y, max_like_cnt, max_empty_cnt = 0, 0, -1, -1

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if maps[i][j] != 0:  # 이미 학생이 앉은 경우
                continue

            like_cnt = 0
            empty_cnt = 0
            for k in range(4):
                nx = i + dx[k]
                ny = j + dy[k]
                if 0 < nx <= N and 0 < ny <= N:
                    if maps[nx][ny] in like_list:
                        like_cnt += 1
                    elif maps[nx][ny] == 0:
                        empty_cnt += 1

            if like_cnt > max_like_cnt:
                x, y = i, j
                max_like_cnt, max_empty_cnt = like_cnt, empty_cnt
            if like_cnt == max_like_cnt and empty_cnt > max_empty_cnt:
                x, y = i, j
                max_like_cnt, max_empty_cnt = like_cnt, empty_cnt
    maps[x][y] = student_idx

answer = 0
for i in range(1, N + 1):
    for j in range(1, N + 1):
        cnt = 0
        for k in range(4):
            nx, ny = i + dx[k], j + dy[k]
            if 0 < nx <= N and 0 < ny <= N:
                if maps[nx][ny] in adj_dict[maps[i][j]]:
                    cnt += 1
        if cnt == 1:
            answer += 1
        elif cnt == 2:
            answer += 10
        elif cnt == 3:
            answer += 100
        elif cnt == 4:
            answer += 1000
print(answer)
