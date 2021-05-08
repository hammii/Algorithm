def solution(n, k, cmd):
    answer = ''

    num_list = [i for i in range(n)]
    del_list = []

    # print(num_list)

    for c in cmd:
        if c[0] == 'D':
            k += int(c[2])
        elif c[0] == 'U':
            k -= int(c[2])
        elif c[0] == 'C':
            del_list.append(num_list[k])
            del num_list[k]
            if k == len(num_list):
                k -= 1
        elif c[0] == 'Z':
            n = del_list.pop()
            if n < num_list[k]:
                k += 1

            num_list.append(n)
            num_list.sort()
        # print(k)

    # print(del_list)

    cnt = 0
    for n in num_list:
        if cnt != n:
            answer += 'X'
            cnt += 1
        if cnt == n:
            answer += 'O'
        cnt += 1

    # print(answer)
    return answer


solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"])
