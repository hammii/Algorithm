def convert(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)
    if q == 0:
        return T[r]
    else:
        return convert(q, base) + T[r]


def solution(n, t, m, p):
    MAX = t * m + 1
    num_list = []

    for i in range(MAX):
        if len(convert(i, n)) > 1:
            num_list += list(convert(i, n))
        else:
            num_list += convert(i, n)

    return ''.join(num_list[i * m + (p - 1)] for i in range(t))
