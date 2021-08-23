def solution(n, k, cmd):
    nodes = {0: [n - 1, 1]}  # idx, left, right
    for i in range(1, n):
        if i == n - 1:
            nodes[i] = [i - 1, 0]
        else:
            nodes[i] = [i - 1, i + 1]

    del_num = []
    for c in cmd:
        if c[0] == 'Z':  # 복구
            idx, val = del_num.pop()
            prev, next = val
            nodes[idx] = [prev, next]
            nodes[prev][1] = idx
            nodes[next][0] = idx
        elif c[0] == 'C':  # 삭제
            nodes[nodes[k][0]][1] = nodes[k][1]
            nodes[nodes[k][1]][0] = nodes[k][0]
            del_num.append([k, nodes[k]])
            temp = nodes[k]
            del nodes[k]

            if temp[1] == 0:  # 마지막 노드인 경우
                k = temp[0]
            else:
                k = temp[1]
        elif c[0] == 'U':
            cnt = int(c.split(' ')[1])
            while cnt:
                k = nodes[k][0]
                cnt -= 1
        elif c[0] == 'D':
            cnt = int(c.split(' ')[1])
            while cnt:
                k = nodes[k][1]
                cnt -= 1

    answer = ''
    for i in range(n):
        if nodes.get(i) is None:
            answer += 'X'
        else:
            answer += 'O'
    return answer
