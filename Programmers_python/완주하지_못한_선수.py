from collections import defaultdict

def solution(participant, completion):
    dictionary = defaultdict(int)
    answer = ''
    
    for p in participant:
        dictionary[p] += 1
    for c in completion:
        dictionary[c] -= 1
        
    for key,value in dictionary.items():
        if value == 1:
            answer = key
    
    return answer
