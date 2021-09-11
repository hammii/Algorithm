import math


def convert(n, q):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)

    return rev_base[::-1]


def isPrime(x):
    if x == 1:
        return False

    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True


def isContain(x):
    for i in x:
        if i == '0':
            return True
    return False


def solution(n, k):
    answer = 0
    converted = convert(n, k)

    for i in range(len(converted)):
        for j in range(i + 1, len(converted) + 1):
            flag = False

            if isContain(converted[i:j]):
                continue

            prime = int(converted[i:j])
            if i == 0 and j != len(converted):
                if converted[j] == '0':
                    if isPrime(prime):
                        flag = True
            elif i != 0 and j != len(converted):
                if converted[i - 1] == '0' and converted[j] == '0':
                    if isPrime(prime):
                        flag = True
            elif i != 0 and j == len(converted):
                if converted[i - 1] == '0':
                    if isPrime(prime):
                        flag = True
            else:
                if isPrime(prime):
                    flag = True

            if flag:
                answer += 1

    return answer


n = 110011
k = 10
print(solution(n, k))
