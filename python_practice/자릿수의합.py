import sys

N = int(sys.stdin.readline().rstrip())
num = list(map(int, sys.stdin.readline().rstrip().split()))


def digit_num(x):
    x_sum = 0
    while x > 0:
        x_sum += x % 10
        x = x // 10
    return x_sum


max_digit = 0
answer = 0
for n in num:
    digit = digit_num(n)
    if digit > max_digit:
        max_digit = digit
        answer = n

print(answer)
