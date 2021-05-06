from itertools import product


def compare(user_id, banned_id):
    if len(user_id) != len(banned_id):
        return False

    for i in range(len(user_id)):
        if banned_id[i] == '*':
            continue
        if user_id[i] != banned_id[i]:
            return False

    return True


def solution(user_id, banned_id):
    my_list = []
    for i in range(len(banned_id)):
        available = []
        for user in user_id:
            if compare(user, banned_id[i]):
                available.append(user)
        my_list.append(available)

    answer = []
    for a in product(*my_list):
        if len(set(a)) == len(banned_id):   # 중복 선택을 제외했을 때 len 과 같은 경우
            answer.append(frozenset(a))

    return len(set(answer))
