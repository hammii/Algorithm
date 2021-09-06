def solution(dartResult):
    answer = [0] * 3
    idx = 0
    i = 0
    while i < len(dartResult):
        if '0' <= dartResult[i] <= '9':
            if dartResult[i] == '1' and dartResult[i + 1] == '0':
                answer[idx] = 10
                i += 2
                continue
            else:
                answer[idx] = int(dartResult[i])
                i += 1
                continue
        elif dartResult[i] == 'S':
            idx += 1
        elif dartResult[i] == 'D':
            answer[idx] = pow(answer[idx], 2)
            idx += 1
        elif dartResult[i] == 'T':
            answer[idx] = pow(answer[idx], 3)
            idx += 1
        elif dartResult[i] == '*':
            answer[idx-1] *= 2
            if idx > 1:
                answer[idx - 2] *= 2
        elif dartResult[i] == '#':
            answer[idx-1] *= -1
        i += 1

    return sum(answer)


print(solution("1S*2T*3S"))
