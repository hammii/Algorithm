def check(mid, stones, k):
    temp = stones[:]

    for i in range(len(temp)):
        if temp[i] < mid:
            temp[i] = 0

    flag = 0
    for stone in temp:
        if stone == 0:
            flag += 1
            if flag == k:
                break
        else:
            flag = 0
    if flag == k:
        return False

    return True


def solution(stones, k):
    min_stone = min(stones)
    max_stone = max(stones)

    while min_stone <= max_stone:
        mid = (min_stone + max_stone) // 2

        if check(mid, stones, k):  # 건널 수 있다
            min_stone = mid + 1
        else:
            max_stone = mid - 1

    answer = (min_stone + max_stone) // 2
    return answer
