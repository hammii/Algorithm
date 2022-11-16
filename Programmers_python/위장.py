from collections import defaultdict

def solution(clothes):
    answer = 1
    clothes_dict = defaultdict(list)

    for c in clothes:
        clothes_dict[c[1]].append(c[0])

    for key, value in clothes_dict.items():
        answer *= len(value)+1

    return answer - 1
