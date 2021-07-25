# 22:52 시작, 22:59 종료
import sys

S = list(map(int, list(sys.stdin.readline().rstrip())))
ans = S[0]

for i in range(1, len(S)):
    ans = max(ans + S[i], ans * S[i])

print(ans)