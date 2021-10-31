def solution(numbers):
    answer = []
    for num in numbers:
        if num % 2 == 0:
            answer.append(num + 1)
        else:
            bin_num = bin(num)[2:]
            bin_num = '0' + bin_num
            last_one = bin_num.rfind('0')
            bin_num = list(bin_num)
            bin_num[last_one] = '1'
            bin_num[last_one + 1] = '0'
            answer.append(int(''.join(bin_num), 2))

    return answer
