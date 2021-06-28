import sys


def getPrime(num):
    eratos = [False, False] + [True] * (num - 2)

    sqrt = int(num ** 0.5)
    for i in range(2, sqrt + 1):
        if eratos[i]:
            for j in range(i * 2, num, i):
                eratos[j] = False

    eratos[2] = False
    return eratos


my_list = []
while True:
    N = int(sys.stdin.readline().rstrip())
    if N == 0:
        break
    else:
        my_list.append(N)

primeList = getPrime(max(my_list))

for n in my_list:
    flag = False
    for i in range(3, n // 2 + 1):
        if primeList[i] and primeList[n - i]:
            print('{} = {} + {}'.format(n, i, n - i))
            flag = True
            break

    if not flag:
        print("Goldbach's conjecture is wrong.")
