# 1:57 시작, 12:18 종료
def solution(N, stages):
    answer = []
    user = [0] * (N + 2)  # 스테이지에 도달한 사람
    fail = [0] * (N + 2)  # 스테이지에 머물러 있는 사람
    fail_rate = []  # 실패율

    for s in stages:
        for i in range(1, s + 1):
            user[i] += 1
            if i == s:
                fail[i] += 1

    for i in range(N):
        if user[i + 1] == 0:
            fail_rate.append((0, i + 1))
        else:
            fail_rate.append((fail[i + 1] / user[i + 1], i + 1))

    fail_rate.sort(key=lambda x: (-x[0], x[1]))

    for f in fail_rate:
        answer.append(f[1])

    return answer
