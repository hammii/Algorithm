import math

def solution(arr):
    gcd, lcm = arr[0], arr[0]
    
    for i in range(1, len(arr)):
        gcd = math.gcd(gcd, arr[i])
        lcm = lcm * arr[i] // math.gcd(lcm, arr[i])
        
    return lcm
