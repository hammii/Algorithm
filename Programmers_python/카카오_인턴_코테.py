def solution(s):
    dict = {'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4',
            'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9'}
    answer = ''
    temp = ''

    for a in s:
        if '0' <= a <= '9':
            answer += a
        else:
            temp += a

        if temp in dict:
            answer += dict[temp]
            temp = ''

    return int(answer)
