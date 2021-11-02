def solution(s):
    words = list(s.split(' '))
    for i in range(len(words)):
        words[i] = words[i].capitalize()
    return ' '.join(words)
