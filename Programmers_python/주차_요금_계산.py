import math

def solution(fees, records):
    answer = []
    record_time = {}
    
    for record in records:
        time, car_num, record_type = record.split()
        
        if record_type == 'IN':
            if car_num in record_time.keys():
                record_time[car_num] -= int(time.split(":")[0])*60 + int(time.split(":")[1])
            else:
                record_time[car_num] = 0 - (int(time.split(":")[0])*60 + int(time.split(":")[1]))
        else:
            if car_num in record_time.keys():
                record_time[car_num] += int(time.split(":")[0])*60 + int(time.split(":")[1])    
            else:
                record_time[car_num] = 0 + int(time.split(":")[0])*60 + int(time.split(":")[1])
        
    for key, value in record_time.items():
        if value <= 0:
            record_time[key] += 23 * 60 + 59
            
    record_time = sorted(record_time.items())
    
    for record in record_time:
        if record[1] > fees[0]:
            money = fees[1] + math.ceil((record[1] - fees[0]) / fees[2]) * fees[3]
        else:
            money = fees[1]
        answer.append(money)
    
    return answer
