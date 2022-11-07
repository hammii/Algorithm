def isPrime(n):
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

def solution(n):
    answer = 0
    
    for i in range(2, n+1):
        if isPrime(i):
            answer += 1
            
    return answer
