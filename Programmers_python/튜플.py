def solution(s):
    numList = list(map(int, s.replace("{", "").replace("}", "").split(",")))
    numSet = set(numList)
    answer = []
    cntList = []

    for num in numSet:
        cnt = numList.count(num)
        cntList.append([num, cnt])

    cntList.sort(key=lambda x: -x[1])
    for cnt in cntList:
        answer.append(cnt[0])

    return answer
