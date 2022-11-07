def solution(food):
    answer = ''
    for i in range(1, len(food)):
        if food[i] // 2 > 0:
            answer += str(i) * int(food[i]//2)
    
    answer += '0' + answer[::-1]
    return answer
