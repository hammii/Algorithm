def solution(babbling):
    answer = 0
    
    for b in babbling:
        b = b.replace("ayaaya", "-").replace("yeye", "-").replace("woowoo", "-").replace("mama", "-")
        b = b.replace("aya", " ").replace("ye", " ").replace("woo", " ").replace("ma", " ").replace(" ", "")
        
        if b == "":
            answer += 1
        
    return answer
