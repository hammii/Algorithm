def solution(numbers, hand):
    answer = ''
    left, right = 10, 12

    for number in numbers:
        if number in [1, 4, 7]:
            answer += 'L'
            left = number
        elif number in [3, 6, 9]:
            answer += 'R'
            right = number
        elif number in [2, 5, 8, 0]:
            if number == 0:
                number = 11

            diff_l = abs(left - number)
            diff_r = abs(right - number)
            diff_l = diff_l // 3 + diff_l % 3
            diff_r = diff_r // 3 + diff_r % 3

            if diff_l < diff_r:
                answer += 'L'
                left = number
            elif diff_l > diff_r:
                answer += 'R'
                right = number
            else:
                if hand == 'left':
                    answer += 'L'
                    left = number
                elif hand == 'right':
                    answer += 'R'
                    right = number

    return answer
