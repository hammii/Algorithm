import sys
input = sys.stdin.readline


def check(arr, mid):
    temp = []
    cnt = 1

    for i in arr:
        temp.append(i)
        gap = max(temp) - min(temp)

        if gap > mid:
            cnt += 1
            temp.clear()
            temp.append(i)
    return cnt <= M


N, M = map(int, input().rstrip().split())
arr = list(map(int, (input().rstrip().split())))

left = 0
right = max(arr)
answer = right

while left <= right:
    mid = (left + right) // 2
    if check(arr, mid):
        if answer > mid:
            answer = mid
        right = mid - 1
    else:
        left = mid + 1

print(answer)
