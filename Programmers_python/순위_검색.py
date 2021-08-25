from itertools import combinations


def solution(info, query):
    answer = []
    db = {}  # word, score 형태로 저장

    for i in range(len(info)):
        info[i] = info[i].split()
        word = info[i][:-1]
        score = int(info[i][-1])
        for n in range(5):
            comb = list(combinations(range(4), n))
            for change_list in comb:
                temp = word[:]
                for change in change_list:
                    temp[change] = '-'
                key = ''.join(temp)

                if key in db:
                    db[key].append(score)
                else:
                    db[key] = [score]

    for value in db.values():
        value.sort()

    for q in query:
        q = q.replace('and', '').split()
        q_word = ''.join(q[:-1])
        q_score = int(q[-1])

        if q_word in db:
            data = db[q_word]
            if len(data) > 0:
                start, end = 0, len(data)
                while start != end and start != len(data):
                    if data[(start + end) // 2] >= q_score:
                        end = (start + end) // 2
                    else:
                        start = (start + end) // 2 + 1
                answer.append(len(data) - start)
        else:
            answer.append(0)

    return answer
