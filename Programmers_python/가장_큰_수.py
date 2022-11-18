from functools import cmp_to_key

def compare(a, b):
    if (a + b) > (b + a):
        return -1
    else:
        return 1
    
def solution(numbers):
    numbers = list(map(str, numbers))
    return str(int(''.join(sorted(numbers, key=cmp_to_key(compare)))))
