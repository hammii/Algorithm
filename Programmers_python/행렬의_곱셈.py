def solution(arr1, arr2):
    answer = [[0] * len(arr2[0]) for _ in range(len(arr1))]

    for row in range(len(arr1)):
        for col in range(len(arr2[0])):
            for k in range(len(arr1[row])):
                answer[row][col] += arr1[row][k] * arr2[k][col]
    return answer
