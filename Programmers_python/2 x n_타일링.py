def solution(n):
    result = [0] * (n+1)
    
    result[1], result[2] = 1, 2
    for i in range(3, n+1):
        result[i] = (result[i-2] + result[i-1]) % 1000000007
    
    return result[n]
