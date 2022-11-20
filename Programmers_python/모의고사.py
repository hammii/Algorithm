def solution(answers):
    p1 = [1, 2, 3, 4, 5] * 10000
    p2 = [2, 1, 2, 3, 2, 4, 2, 5] * 10000
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * 10000
    cnt = [0, 0, 0]
    answer = []
    
    for i in range(len(answers)):
        if answers[i] == p1[i]:
            cnt[0] += 1
        if answers[i] == p2[i]:
            cnt[1] += 1
        if answers[i] == p3[i]:
            cnt[2] += 1
            
    for i in range(len(cnt)):
        if cnt[i] == max(cnt):
            answer.append(i+1)
    
    return answer
