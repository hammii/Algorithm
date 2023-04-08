def solution(name, yearning, photo):
    answer = []
    name_dict = dict()
    
    for i in range(len(name)):
        name_dict[name[i]] = yearning[i]
        
    for i in photo:
        score = 0
        for name in i:
            if name in name_dict.keys():
                score += name_dict[name]
        answer.append(score)
        
    return answer
