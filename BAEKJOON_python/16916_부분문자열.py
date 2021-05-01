import sys
input = sys.stdin.readline

S = input().strip()
P = input().strip()

s_idx = []
answer = 0

for i in range(len(S)):  # 첫 문자 나오는 인덱스 저장
    if S[i] == P[0]:
        s_idx.append(i)


for idx in s_idx:
    flag = True
    i = idx
    for p in P:
        if i >= len(S):  # S 문자열 넘어가면 종료
            flag = False
            break

        if p != S[i]:
            flag = False
            break
        else:
            i += 1
    if flag is True:
        answer = 1
        break

print(answer)
