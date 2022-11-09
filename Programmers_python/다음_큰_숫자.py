def convert(n):
    base = ''
    
    while n > 0:
        n, mod = divmod(n, 2)
        base += str(mod)
    
    base = base[::-1]
    return base

def solution(n):
    n_cnt = convert(n).count('1')
    
    while True:
        n += 1
        if convert(n).count('1') == n_cnt:
            return int(n)
