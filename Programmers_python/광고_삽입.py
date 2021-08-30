def timeToSecond(str):
    parse = list(map(int, str.split(':')))
    return parse[0] * 3600 + parse[1] * 60 + parse[2]


def solution(play_time, adv_time, logs):
    play_time_sec = timeToSecond(play_time)
    adv_time_sec = timeToSecond(adv_time)
    total_time = [0] * (play_time_sec + 1)  # 누적 재생 시간

    for i in range(len(logs)):
        split = logs[i].split("-")  # 시작, 종료
        total_time[timeToSecond(split[0])] += 1
        total_time[timeToSecond(split[1])] -= 1

    for i in range(1, play_time_sec + 1):
        total_time[i] += total_time[i - 1]
    for i in range(1, play_time_sec + 1):
        total_time[i] += total_time[i - 1]

    max_time = total_time[adv_time_sec - 1]
    max_start_time = 0
    i = 0
    while i + adv_time_sec <= play_time_sec:
        temp = total_time[i + adv_time_sec] - total_time[i]

        if temp > max_time:
            max_time = temp
            max_start_time = i + 1

        i += 1

    return '{:02d}:{:02d}:{:02d}'.format(max_start_time // 3600, (max_start_time // 60) % 60, max_start_time % 60)
