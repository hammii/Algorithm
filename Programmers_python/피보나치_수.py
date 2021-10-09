def fibo(n):
    arr = []
    for i in range(n):
        if i < 2:
            arr.append(1)
        else:
            arr.append(arr[i - 1] + arr[i - 2])

    return arr[n - 1]


def solution(n):
    answer = fibo(n)
    return answer % 1234567
