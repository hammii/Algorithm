from itertools import permutations

def isPrime(n):
    if n == 0 or n == 1:
        return False
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    numbers = list(numbers)
    prime_set = set()
    
    for n in numbers:
        if isPrime(int(n)):
            prime_set.add(int(n))
    
    for size in range(2, len(numbers)+1):
        per_list = list(permutations(numbers, size))
        for per in per_list:
            num = int(''.join(per))
            if isPrime(num):
                prime_set.add(num)

    return len(prime_set)
