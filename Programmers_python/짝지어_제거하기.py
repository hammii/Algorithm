def solution(s):
    stack = []

    for i in range(len(s)):
        if stack and stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])

    return 0 if stack else 1
