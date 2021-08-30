def dfs(str):
    if str == '':
        return str

    cnt, cnt_left, cnt_right = 0, 0, 0
    split = 0
    for i in range(0, len(str) + 1):
        if str[i] == '(':
            cnt_left += 1
        elif str[i] == ')':
            cnt_right += 1
        cnt += 1

        if cnt % 2 == 0 and cnt_left == cnt_right:
            split = i
            break

    u = str[:split + 1]
    v = str[split + 1:]

    if checkStr(u):
        return u + dfs(v)
    else:
        u = u[1:-1]
        for i in range(len(u)):
            if u[i] == '(':
                u = u[:i] + ')' + u[i + 1:]
            elif u[i] == ')':
                u = u[:i] + '(' + u[i + 1:]

    return '(' + dfs(v) + ')' + u


def checkStr(str):
    if str == '':
        return True

    stack = []
    for s in str:
        if s == '(':
            stack.append(s)
        elif s == ')':
            if not stack:  # 스택이 빈 경우
                return False
            else:
                stack.pop()

    return True


def solution(p):
    return dfs(p)
