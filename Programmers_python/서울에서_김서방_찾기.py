def solution(seoul):
    for idx in range(len(seoul)):
        if seoul[idx] == "Kim":
            return "김서방은 " + str(idx) + "에 있다"
