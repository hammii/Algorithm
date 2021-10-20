import sys

n, k = map(int, sys.stdin.readline().rstrip().split())
safe = list(map(int, sys.stdin.readline().rstrip().split()))
length = 2 * n
people = [False] * n


def rotate():
    temp = safe[length - 1]
    for i in range(length - 1, 0, -1):
        safe[i] = safe[i - 1]
    safe[0] = temp

    for i in range(n - 1, 0, -1):
        people[i] = people[i - 1]
    people[0] = False


def check_people():
    people[n - 1] = False
    for i in range(n - 2, -1, -1):
        if people[i] is True:
            if people[i + 1] is True or safe[i + 1] <= 0:
                continue
            safe[i + 1] -= 1
            people[i + 1] = True
            people[i] = False


answer = 1
while True:
    rotate()  # 1
    check_people()  # 2

    if people[0] is False and safe[0] > 0:  # 3
        safe[0] -= 1
        people[0] = True
    if people[n - 1] is True:
        people[n - 1] = False

    cnt = 0
    for i in range(length):
        if safe[i] <= 0:
            cnt += 1
    if cnt >= k:
        break

    answer += 1

print(answer)
