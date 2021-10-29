def solution(s):
    answer = 0
    stack = []
    bracket = {'[': ']', '(': ')', '{': '}'}

    for l in range(len(s)):
        flag = True
        for i in s:
            if i in bracket.keys():
                stack.append(i)
            else:
                if not stack:
                    flag = False
                    break
                top = stack.pop()
                if i == bracket[top]:
                    continue
                else:
                    flag = False
                    break
        if flag and not stack:
            answer += 1
        s = s[1:] + s[0]

    return answer
