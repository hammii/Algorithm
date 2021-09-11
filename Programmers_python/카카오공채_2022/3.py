import math


def getMinute(start, end):
    start_time = start.split(":")
    start_time_m = int(start_time[0]) * 60 + int(start_time[1])
    end_time = end.split(":")
    end_time_m = int(end_time[0]) * 60 + int(end_time[1])

    return end_time_m - start_time_m


def solution(fees, records):
    car_dict = {}  # 차 번호, [입차, 출차, 입차, ...]
    pay_dict = {}

    for re in records:
        re = re.split()
        if re[1] not in car_dict:
            car_dict[re[1]] = []
        car_dict[re[1]].append(re[0])

    for key in car_dict:
        if len(car_dict[key]) % 2 == 1:
            car_dict[key].append('23:59')

    for key in car_dict:
        car_minute = 0
        for i in range(0, len(car_dict[key]), 2):
            minute = getMinute(car_dict[key][i], car_dict[key][i + 1])
            car_minute += minute

        if car_minute <= fees[0]:  # 기본 시간 초과하면
            pay_dict[key] = fees[1]
        else:
            pay_dict[key] = fees[1] + math.ceil((car_minute - fees[0]) / fees[2]) * fees[3]

    sdict = sorted(pay_dict.items())
    answer = [i[1] for i in sdict]

    return answer


fees = [120, 0, 60, 591]
records = ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]
print(solution(fees, records))
