# 23:02 시작, 23:14 종료
import sys

s = sys.stdin.readline().rstrip()
one = s.split('1')
zero = s.split('0')
one_cnt = 0
zero_cnt = 0

for o in one:
    if o == '':
        continue
    else:
        one_cnt += 1

for z in zero:
    if z == '':
        continue
    else:
        zero_cnt += 1

print(min(one_cnt, zero_cnt))
