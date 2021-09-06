def solution(str1, str2):
    set1 = []
    set2 = []

    str1 = str1.lower()
    str2 = str2.lower()

    for i in range(len(str1) - 1):
        if str1[i] < 'a' or str1[i] > 'z' or str1[i + 1] < 'a' or str1[i + 1] > 'z':
            continue
        set1.append(str1[i] + str1[i + 1])

    for i in range(len(str2) - 1):
        if str2[i] < 'a' or str2[i] > 'z' or str2[i + 1] < 'a' or str2[i + 1] > 'z':
            continue
        set2.append(str2[i] + str2[i + 1])

    if not set1 and not set2:
        return 65536

    set1_temp = set1.copy()  # 합집합
    union_set = set1.copy()
    for i in set2:
        if i not in set1_temp:
            union_set.append(i)
        else:
            set1_temp.remove(i)

    set1_temp = set1.copy()  # 교집합
    inter_set = []
    for i in set2:
        if i in set1_temp:
            set1_temp.remove(i)
            inter_set.append(i)

    return int(65536 * (len(inter_set) / len(union_set)))
