import sys
input = sys.stdin.readline

S = input().strip()
P = input().strip()


def getPi(p):
    size = len(p)
    j = 0
    pi = [0] * size

    for i in range(1, size):
        while j > 0 and p[i] != p[j]:
            j = pi[j - 1]
        if p[i] == p[j]:
            j += 1
            pi[i] = j

    return pi


def KMP(s, p):
    pi = getPi(p)
    s_size = len(s)
    p_size = len(p)
    j = 0

    for i in range(s_size):
        while j > 0 and s[i] != p[j]:
            j = pi[j - 1]
        if s[i] == p[j]:
            if j == p_size - 1:
                return 1
            else:
                j += 1

    return 0


print(KMP(S, P))
