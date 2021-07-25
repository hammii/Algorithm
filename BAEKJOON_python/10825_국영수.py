import sys

N = int(sys.stdin.readline().rstrip())
scores = []

for _ in range(N):
    score = sys.stdin.readline().rstrip().split()
    scores.append((score[0], int(score[1]), int(score[2]), int(score[3])))

scores.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for i in range(N):
    print(scores[i][0])