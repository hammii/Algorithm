def getPi(p):
    pi = [0] * len(p)
    j = 0

    for i in range(1, len(p)):
        while j > 0 and p[i] != p[j]:
            j = pi[j - 1]
        if p[i] == p[j]:
            j += 1
            pi[i] = j

    return pi


def KMP(s, p):
    pi = getPi(p)
    j = 0
    cnt = 0
    appear_idx = []

    for i in range(len(s)):
        while j > 0 and s[i] != p[j]:
            j = pi[j - 1]
        if s[i] == p[j]:
            if j == len(p) - 1:
                cnt += 1
                appear_idx.append(i - len(p) + 1)
                j = pi[j]
            else:
                j += 1
    return [cnt, appear_idx]


T = input()
P = input()

answer = KMP(T, P)
print(answer[0])
for idx in answer[1]:
    print(idx + 1, end=' ')
