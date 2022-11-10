def solution(a, b):
    months = [0,31,29,31,30,31,30,31,31,30,31,30,31]
    weeks = ["THU","FRI","SAT","SUN","MON","TUE","WED"]
    day = 0

    for i in range(0, a):
        day += months[i]

    day = (day + b) % 7

    return weeks[day]
