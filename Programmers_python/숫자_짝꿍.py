from collections import Counter

def solution(X, Y):
    answer = '' 
    x_cnt = Counter(X)
    y_cnt = Counter(Y)
    
    for k, v in x_cnt.items():
        if k in y_cnt.keys():
            answer += k * min(x_cnt[k], y_cnt[k])
            
    if answer == '':
        return '-1'
    elif answer.count('0') == len(answer):
        return '0'
    else:
        return ''.join(sorted(answer, reverse=True))
