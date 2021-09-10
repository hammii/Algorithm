from string import ascii_uppercase


def solution(msg):
    answer = []
    alpha_list = list(ascii_uppercase)
    alpha_dict = {}

    for i in range(26):
        alpha_dict[alpha_list[i]] = i + 1

    start = 0
    end = 1
    idx = 27

    w = ''
    c = ''
    msg += ' '
    while True:
        for i in range(end, len(msg) + 1):
            if msg[start:i] not in alpha_dict:
                w = msg[start:i - 1]
                c = msg[i - 1]
                end = i - 1
                break

        answer.append(alpha_dict[w])
        alpha_dict[w + c] = idx
        idx += 1

        start = end
        end = start + 1

        if c == ' ':
            break

    return answer
