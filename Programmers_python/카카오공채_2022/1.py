def solution(id_list, report, k):
    answer = []
    id_dict = {}
    declare = {}

    for id in id_list:
        id_dict[id] = []
        declare[id] = 0

    for re in report:
        info = re.split()
        if info[1] not in id_dict[info[0]]:
            id_dict[info[0]].append(info[1])
            declare[info[1]] += 1

    for key in id_dict:
        i = 0
        for v in id_dict[key]:
            if declare[v] >= k:
                i += 1
        answer.append(i)

    return answer


id_list = ["con", "ryan"]
report = ["ryan con", "ryan con", "ryan con", "ryan con"]
k = 3
print(solution(id_list, report, k))
