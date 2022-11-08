def solution(survey, choices):
    choice_score = [0,3,2,1,0,1,2,3]
    all_score = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0}
    answer = ''
    
    for idx in range(0, len(survey)):
        if choices[idx] < 4:
            all_score[survey[idx][0]] += choice_score[choices[idx]]
        else:
            all_score[survey[idx][1]] += choice_score[choices[idx]]
            
    if all_score["R"] >= all_score["T"]:
        answer += "R"
    else:
        answer += "T"
    if all_score["C"] >= all_score["F"]:
        answer += "C"
    else:
        answer += "F"
    if all_score["J"] >= all_score["M"]:
        answer += "J"
    else:
        answer += "M"
    if all_score["A"] >= all_score["N"]:
        answer += "A"
    else:
        answer += "N"
        
    return answer
