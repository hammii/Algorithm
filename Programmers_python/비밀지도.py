def solution(n, arr1, arr2):
    answer = [''] * n
    my_map1 = [0] * n
    my_map2 = [0] * n

    for i in range(n):
        my_map1[i] = list(format(arr1[i], 'b').zfill(n))
        my_map2[i] = list(format(arr2[i], 'b').zfill(n))

    for i in range(n):
        temp = ''
        for j in range(n):
            if my_map1[i][j] == '1' or my_map2[i][j] == '1':
                temp += '#'
            else:
                temp += ' '
        answer[i] = temp
    return answer
