def solution(s):
    answer = []
    alpha_idx = {}

    for i in range(0, len(s)):
        if s[i] in alpha_idx:
            answer.append(i - alpha_idx[s[i]])    
        else:
            answer.append(-1)
        alpha_idx[s[i]] = i

    return answer
