import sys
from itertools import combinations

L, C = map(int, sys.stdin.readline().rstrip().split())
alpha = list(map(str, sys.stdin.readline().rstrip().split()))

alpha = sorted(alpha)   # 오름차순 정렬
comb = list(combinations(alpha, L))     # 조합

for word in comb:
    word = ''.join(word)
    vowels = 0
    consonants = 0

    for c in word:
        if c in 'aeiou':    # 모음인 경우
            vowels += 1
        else:   # 자음인 경우
            consonants += 1
    if vowels >= 1 and consonants >= 2:
        print(word)