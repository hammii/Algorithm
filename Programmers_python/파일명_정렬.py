import re


def solution(files):
    answer = []

    for file in files:
        number = re.findall("\d+", file)
        temp = file.split(number[0], 1)
        answer.append([temp[0], number[0], temp[1]])

    answer.sort(key=lambda x: (x[0].lower(), int(x[1])))

    for i in range(len(answer)):
        answer[i] = ''.join(answer[i])
    return answer
