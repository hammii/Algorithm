def solution(skill, skill_trees):
    answer = 0

    for st in skill_trees:
        idx = 0
        flag = True
        for s in st:
            if s == skill[idx]:
                idx += 1
                if idx == len(skill):
                    break
            elif s not in skill:
                continue
            else:
                flag = False
                break
        if flag:
            answer += 1

    return answer
