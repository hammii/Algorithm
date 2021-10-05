def solution(s):
    stack = []

    for c in s:
        if c == ')':
            if len(stack) == 0:
                return False
            top = stack.pop()
            if top != '(':
                return False

        elif c == '(':
            stack.append(c)

    if len(stack) > 0:
        return False
    return True
