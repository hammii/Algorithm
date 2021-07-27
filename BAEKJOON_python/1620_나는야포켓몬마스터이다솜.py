# 14:49 시작, 15:01 종료
import sys

poketmon = dict()  # 이름으로 들어오면 번호 리턴
poketmon_list = [0]  # 번호로 들어오면 이름 리턴

N, M = map(int, sys.stdin.readline().rstrip().split())
for i in range(1, N + 1):
    name = sys.stdin.readline().rstrip()
    poketmon_list.append(name)
    poketmon[name] = i

for _ in range(M):
    command = sys.stdin.readline().rstrip()

    if 'A' <= command[0] <= 'Z':
        print(poketmon[command])
    else:
        print(poketmon_list[int(command)])
