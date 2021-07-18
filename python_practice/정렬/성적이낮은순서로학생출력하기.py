# 15:22 시작, 15:27 종료
import sys

N = int(sys.stdin.readline().rstrip())
student = []

for _ in range(N):
    string = sys.stdin.readline().rstrip().split()
    student.append((string[0], int(string[1])))

student = sorted(student, key=lambda x: x[1])

for s in student:
    print(s[0], end=' ')
