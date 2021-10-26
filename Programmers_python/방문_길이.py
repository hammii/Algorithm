def solution(dirs):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, 1, -1]
    x, y = 5, 5
    nx, ny = 0, 0
    road_set = set()  # 중복 확인
    answer = 0

    for i in range(len(dirs)):
        if dirs[i] == 'U':
            nx, ny = x + dx[0], y + dy[0]
        elif dirs[i] == 'D':
            nx, ny = x + dx[1], y + dy[1]
        elif dirs[i] == 'R':
            nx, ny = x + dx[2], y + dy[2]
        elif dirs[i] == 'L':
            nx, ny = x + dx[3], y + dy[3]

        if not (0 <= nx < 11 and 0 <= ny < 11):
            continue
        if (x, y, nx, ny) not in road_set:
            answer += 1

        road_set.add((x, y, nx, ny))
        road_set.add((nx, ny, x, y))
        x, y = nx, ny
    return answer
