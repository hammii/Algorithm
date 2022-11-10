def convert(n, k):
    result = ''

    while n >= k:
        result += str(n % k)
        n = n // k       
    result += str(n)

    return result[::-1]

def isPrime(n):
    if n == 1: return False

    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False

    return True

def solution(n, k):
    answer = 0
    converted_num = convert(n, k)

    for num in converted_num.split('0'):
        if num and isPrime(int(num)):
            answer += 1

    return answer
