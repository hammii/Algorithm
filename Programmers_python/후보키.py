from itertools import combinations


def has_duplicates2(seq):
    seen = []
    unique_list = [x for x in seq if x not in seen and not seen.append(x)]
    return len(seq) != len(unique_list)


def solution(relation):
    answer = []
    row = len(relation)
    column = len(relation[0])
    my_list = [i for i in range(column)]

    for i in range(1, column + 1):
        comb_list = list(combinations(my_list, i))  # column 조합

        for c in comb_list:  # 최소성 체크
            flag = False
            for a in answer:
                if set(c).issuperset(set(a)):
                    flag = True
                    break
            if flag:
                continue

            comb_table = [] * row
            for i in range(row):
                row_list = []
                for j in range(column):
                    if j in c:
                        row_list.append(relation[i][j])
                comb_table.append(row_list)

            if not has_duplicates2(comb_table):  # 2차원 배열 중복 확인
                answer.append(c)

    return len(answer)
