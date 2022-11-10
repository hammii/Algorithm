def solution(id_list, report, k):
    report_dict = dict()
    banned_cnt = dict()
    answer = []
    
    for id in id_list:
        report_dict[id] = set()
        banned_cnt[id] = 0

    for r in set(report):
        user, target = r.split()[0], r.split()[1]
        report_dict[user].add(target)
        banned_cnt[target] += 1
    
    for id in id_list:
        result = 0
        for target in report_dict[id]:
            if banned_cnt[target] >= k:
                result += 1
        answer.append(result)
        
    return answer
