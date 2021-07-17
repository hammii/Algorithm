import sys

N = int(sys.stdin.readline().rstrip())
score = list(map(int, sys.stdin.readline().rstrip().split()))

avg = round(sum(score) / len(score))

min_abs = 101
high_score = 0
index = 101
for i in range(N):
    if abs(avg - score[i]) < min_abs:
        min_abs = abs(avg - score[i])
        high_score = score[i]
        index = i
    elif abs(avg - score[i]) == min_abs:
        if score[i] > high_score:
            min_abs = abs(avg - score[i])
            high_score = score[i]
            index = i

print(avg, index + 1)
