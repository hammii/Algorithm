def solution(enroll, referral, seller, amount):
    answer = []
    person_dict = {}    # 추천인 저장
    result_dict = {}    # 금액 저장
    amount = [a * 100 for a in amount]

    for idx, name in enumerate(enroll):
        person_dict[name] = referral[idx]
        result_dict[name] = 0

    for idx, name in enumerate(seller):
        person_name = name
        price = amount[idx]

        while person_name in person_dict:
            price_10 = int(price * 0.1)
            result_dict[person_name] += price - price_10  # 자기가 90% 가짐
            person_name = person_dict[person_name]  # 다음 사람
            price = price_10

    for name in enroll:
        answer.append(result_dict[name])

    return answer
